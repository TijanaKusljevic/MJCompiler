package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Map;

import javax.print.attribute.standard.PrinterLocation;

import org.apache.log4j.Logger;

import com.sun.org.apache.bcel.internal.generic.ArrayType;

import java_cup.parser;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.structure.HashTableDataStructure;

public class SemanticAnalyzer extends VisitorAdaptor {

	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	int nVars;
	int forovi = 0;
	int actParams = 0;
	int formPars = 0;
	int tip = 0;  //1 kad naidej na Broj.JEDAN, 2 kad naidje na element niza
	int fleg = 0; //int i enum da su medjusobno isti
	int ebrojac=0;  //kolko ima enuma
	int enumlastvalue=0;
	int velniza=0;
	Obj objekat = null;  //uzima objekat kad naidje na ime enuma da tu stavlja parametre
	String ime = null; // ono pre tacke kod enuma
	Struct lastType = null;
	ArrayList<Integer> paramlist = new ArrayList<Integer>(); //broj parametara kod fja
	
	ArrayList<Integer> brojeviconst = new ArrayList<Integer>(); // kad je vise konstanti u nizu
	ArrayList<Integer> isarray = new ArrayList<Integer>(); // da li je niz deklarisan, samo za ispis poruke glupo
	ArrayList<Integer> enumvalues = new ArrayList<Integer>(); //vrednosti enuma, ako ide npr 0, 1, 7 da daalje ide 8
	Struct arrayType=null;  //kod init liste za niz da se zna samo kog je tipa
	
	ArrayList<ArrayList<Struct>> velikalista = new ArrayList<ArrayList<Struct>>(); //lista listi tipova parametara
	// za svaku fju po jedna lista
	HashTableDataStructure enumi = null; //nista

	private Struct var_type = Tab.noType;

	public static final Struct boolType = new Struct(Struct.Bool);
	public static final Struct noneType = new Struct(Struct.None);
	public static final Struct enumType = new Struct(Struct.Enum, Tab.intType);

	public SemanticAnalyzer() {
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getPName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(VarDecl varDecl) {
		if (isarray.remove(isarray.size() - 1) == 0) {
			report_info("Deklarisana promenljiva " + varDecl.getVarName(), varDecl);
			// Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(),
			// varDecl.getType().struct);
			Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), lastType);
		} else {
			report_info("Deklarisan niz " + varDecl.getVarName(), varDecl);
			Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), new Struct(Struct.Array, lastType));
			// Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), new
			// Struct(Struct.Array, varDecl.getType().struct));
		}
		// lastType = varDecl.getType().struct;
	}

	public void visit(EnumDecl ed) {
		//Obj obj = new Obj(Obj.Con, ed.getOptName(), Tab.intType);
		//objekat.getType().getMembersTable().insertKey(obj);
		//obj.setAdr(ebrojac++);
	}
	
	public void visit(EnumiNovo kk) {
		String pr=kk.getPr();
		String dr=kk.getDr();
		Obj p= Tab.find(pr);
		Obj d= Tab.find(dr);
		for(Obj o: p.getType().getMembersTable().symbols()) {
			if(objekat.getType().getMembersTable().searchKey(o.getName())==null)
				objekat.getType().getMembersTable().insertKey(o);
		}
	}
	
	public void visit(FirstEnum ed) {
		Obj obj = new Obj(Obj.Con, ed.getOptName(), Tab.intType);
		objekat.getType().getMembersTable().insertKey(obj);
		if(ed.getNumConst() instanceof YesNumConst) {
			obj.setAdr(enumlastvalue);
			enumvalues.add(enumlastvalue);
			ebrojac=++enumlastvalue;
			
		} else {
			if(!validvalue(ebrojac)) {
				report_error("Nedozvoljena vrednost u nabrajanju na liniji " + ed.getLine(), null);
			}
			enumvalues.add(ebrojac);
			obj.setAdr(ebrojac++);
		}
		
	}
	
	public void visit(YesNumConst y) {
		enumlastvalue=y.getN1();
		if(!validvalue(enumlastvalue)) {
			report_error("Nedozvoljena vrednost u nabrajanju na liniji " + y.getLine(), null);
		}
	}

	public void visit(EnumName ed) {
		// Struct imeneko = new Struct(Struct.Enum, Tab.intType);

		// enumi = new HashTableDataStructure();
		// imeneko.setMembers(enumi);
		enumvalues=new ArrayList<Integer>();
		ebrojac=0;
		ed.obj = Tab.insert(Obj.Type, ed.getVarType(), new Struct(Struct.Enum, new HashTableDataStructure()));
		objekat = ed.obj;

	}
	

	public void visit(YesEnumList el) {
		Obj obj = new Obj(Obj.Con, el.getOptName(), Tab.intType);
		objekat.getType().getMembersTable().insertKey(obj);
		if(el.getNumConst() instanceof YesNumConst) {
			obj.setAdr(enumlastvalue);
			enumvalues.add(enumlastvalue);
			ebrojac=++enumlastvalue;
			
		} else {
			if(!validvalue(ebrojac)) {
				report_error("Nedozvoljena vrednost u nabrajanju na liniji " + el.getLine(), null);
			}
			enumvalues.add(ebrojac);
			obj.setAdr(ebrojac++);
		}
	}
	
	public boolean validvalue(int v) {
		for(Integer i : enumvalues) {
			if(i==v) return false;
		}
		return true;
	}

	public void visit(ConstDeclVarDecl varDecl) {
		Struct varType = varDecl.getType().struct;
		// lastType = varDecl.getType().struct;
		boolean proslo = false;
		// Obj typeNode = Tab.find(varDecl.getTypeName());
		if (varType == Tab.intType && varDecl.getConstDecl().struct == Tab.intType) {
			proslo = true;
		}
		if (varType == Tab.charType && varDecl.getConstDecl().struct == Tab.charType) {
			proslo = true;
		}

		if (varType == boolType && varDecl.getConstDecl().struct == boolType) {
			proslo = true;
		}

		if (!proslo) {
			report_error("Dodela i deklaracija nisu istog tipa na liniji " + varDecl.getLine(), null);
		}
		report_info("Deklarisana konstanta " + varDecl.getVarName(), varDecl);
		Obj varNode = Tab.insert(Obj.Con, varDecl.getVarName(), varDecl.getType().struct);
		varNode.setAdr(brojeviconst.remove(brojeviconst.size() - 1));

	}

	public void visit(ConstantDeclarationTrue cdt) {
		cdt.struct = boolType;
		brojeviconst.add(1);

	}

	public void visit(ConstantDeclarationFalse cdf) {
		cdf.struct = boolType;
		brojeviconst.add(0);

	}

	public void visit(ConstantDeclarationNumber cdn) {
		cdn.struct = Tab.intType;
		brojeviconst.add(cdn.getN1());

	}

	public void visit(ConstantDeclaration cdn) {
		cdn.struct = Tab.intType;
	}

	public void visit(ConstantDeclarationChar cdc) {
		cdc.struct = Tab.charType;
		brojeviconst.add((int) cdc.getC1());

	}

	public void visit(CharConst cc) {
		cc.struct = Tab.charType;
	}

	public void visit(Type type) {

		Obj typeNode = Tab.find(type.getTypeName());

		if (typeNode.getType().getKind() == Struct.Enum) {
			type.struct = Tab.intType;

		} else {

			if (typeNode == Tab.noObj) {
				report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola", null);
				type.struct = Tab.noType;
			} else {
				if (Obj.Type == typeNode.getKind()) {
					type.struct = typeNode.getType();
				} else {
					report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip ", type);
					type.struct = Tab.noType;
				}
			}
		}
		lastType = type.struct;
	}

	public void visit(MethodDecl methodDecl) {
		if (!returnFound && currentMethod.getType() != Tab.noType) {
			report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funcija " + currentMethod.getName()
					+ " nema return iskaz!", null);
		}

		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		returnFound = false;
		currentMethod = null;
	}

	public void visit(MethodTypeName methodTypeName) {
		currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), methodTypeName.getType().struct);
		methodTypeName.obj = currentMethod;
		Tab.openScope();
		report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
	}

	public void visit(MetodTypeVoid mtv) {
		currentMethod = Tab.insert(Obj.Meth, mtv.getMethName(), Tab.noType);
		mtv.obj = currentMethod;
		Tab.openScope();
		report_info("Obradjuje se funkcija " + mtv.getMethName(), mtv);
	}

	public void visit(Assignment assignment) {
		if (assignment.getDesignator().obj.getType().getKind() == Struct.Enum
				&& assignment.getExpr().struct == Tab.intType) {
			if (fleg == 1) {
				fleg = 0;
			} else {
				report_error("Greska na liniji " + assignment.getLine() + " : "
						+ " nekompatibilni tipovi u dodeli vrednosti ", null);
			}
		} else {
			if(assignment.getExpr().struct==null) {
				System.out.println("ovdeee");
			}
			if (!assignment.getExpr().struct.assignableTo(assignment.getDesignator().obj.getType()))
				report_error("Greska na liniji " + assignment.getLine() + " : "
						+ " nekompatibilni tipovi u dodeli vrednosti poyy ", null);
		}
	}

	public void visit(PrintStmt printStmt) {
		printCallCount++;

		if (!(printStmt.getExpr().struct == Tab.charType || printStmt.getExpr().struct == Tab.intType
				|| printStmt.getExpr().struct == boolType)) {
			report_error("Nedozvoljen tip argumenta prosledjen funkciji print na liniji " + printStmt.getLine(), null);
		}
	}

	public void visit(ReturnExpr returnExpr) {
		returnFound = true;
		Struct currMethType = currentMethod.getType();
		if (!currMethType.compatibleWith(returnExpr.getExpr().struct)) {
			report_error("Greska na liniji " + returnExpr.getLine() + " : "
					+ "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije "
					+ currentMethod.getName(), null);
		}
	}

	public void visit(ReturnNoExpr rne) {

		returnFound = true;
		Struct currMethType = currentMethod.getType();
		if (currMethType != Tab.noType) {
			report_error("Greska na liniji " + rne.getLine() + " : " + " funkcija " + currentMethod.getName()
					+ " nema povratnu vrednost a nije deklarisana kao void funkcija", null);
		}
	}

	public void visit(ProcCall procCall) {
		Obj func = procCall.getDesignator().obj;
		if (Obj.Meth == func.getKind()) {
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + procCall.getLine(), null);
			// RESULT = func.getType();
		} else {
			report_error("Greska na liniji " + procCall.getLine() + " : ime " + func.getName() + " nije funkcija!",
					null);
			// RESULT = Tab.noType;
		}
	}

	public void visit(AddExpr addExpr) {
		Struct te = addExpr.getExpr().struct;
		Struct t = addExpr.getTerm().struct;

		System.out.println(te.getKind() + " " + t.getKind());
		if ((te.equals(t) && te == Tab.intType) || (te.getKind() == 6 && t == Tab.intType)
				|| (te == Tab.intType && t.getKind() == 6)) {
			addExpr.struct = Tab.intType;
		} else {
			report_error("Greska na liniji " + addExpr.getLine() + " : nekompatibilni tipovi u izrazu za sabiranje.",
					null);
			addExpr.struct = Tab.noType;
		}
	}

	public void visit(TermExpr termExpr) {
		termExpr.struct = termExpr.getTerm().struct;
	}

	public void visit(Term term) {
		term.struct = term.getFactor().struct;

	}

	public void visit(YesMulopList yml) {
		Struct b = yml.getFactor().struct;
		System.out.println(b.getKind());
		if (b != Tab.intType && b.getKind() != 6) {
			report_error("Greska na liniji " + yml.getParent().getLine()
					+ " : nekompatibilni tipovi u mnozenju ili deljenju.", null);
		} else {

		}
	}

	public void visit(Const cnst) {
		cnst.struct = Tab.intType;
		velniza=cnst.getN1();
		
		// report_info("Koriscenje brojcane konstante" + " na liniji " + cnst.getLine(),
		// null);
	}

	/*
	 * public void visit(CharConst cc) { cc.struct=Tab.charType;
	 * report_info("Koriscenje char konstante" + " na liniji " + cc.getLine(),
	 * null); }
	 * 
	 * public void visit(True cc) { report_info("Koriscenje boolean konstante" +
	 * " na liniji " + cc.getLine(), null); }
	 * 
	 * public void visit(False cc) { report_info("Koriscenje boolean konstante" +
	 * " na liniji " + cc.getLine(), null); }
	 */

	public void visit(Var var) {
		var.struct = var.getDesignator().obj.getType();
	}

	public void visit(FuncCall funcCall) {
		Obj func = funcCall.getDesignator().obj;
		int vel = velikalista.size();
		if (velikalista.size() != 0) {
			Obj pom = Tab.find(funcCall.getDesignator().getName());
			ArrayList<Struct> lista = velikalista.get(velikalista.size() - 1); // ovde sam dodala struct

			for (Obj ob : pom.getLocalSymbols()) {

				if (ob.getFpPos() <= lista.size() && ob.getFpPos() != 0) {

					if (lista.get(ob.getFpPos() - 1) != ob.getType()) {
						if (ob.getType().getKind() == lista.get(ob.getFpPos() - 1).getKind()
								&& ob.getType().getKind() == Struct.Array) {

							if (ob.getType().getElemType() != lista.get(ob.getFpPos() - 1).getElemType()) {
								report_error("greska na liniji " + funcCall.getLine()
										+ " nije prosledjen odgovarajuci tip argumenta", null);
							}
						} else {
							report_error("greska na liniji " + funcCall.getLine()
									+ " nije prosledjen odgovarajuci tip argumenta", null);
						}
					}
				}
			}
		}
		if (vel != 0) {
			velikalista.remove(vel - 1);
		}
		int size = paramlist.size() - 1;
		if (size < 0) {
			actParams = 0;
		} else {
			actParams = paramlist.get(size);
		}
		System.out.println(actParams + " " + func.getLevel());
		if (actParams != func.getLevel()) {
			report_error("Greska na liniji " + funcCall.getLine() + " : funkciji " + func.getName()
					+ " nije prosledjen odgovarajuvci broj parametara", null);
		} else {

			actParams = 0;
		}
		if (Obj.Meth == func.getKind()) {
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.struct = func.getType();
		} else {
			report_error("Greska na liniji " + funcCall.getLine() + " : ime " + func.getName() + " nije funkcija!",
					null);
			funcCall.struct = Tab.noType;
		}
		if (size >= 0) {
			paramlist.remove(size);
		}
	}
	
	
	
	
	
	
	public void visit(DesignatorStatementList funcCall) {
		Obj func = funcCall.getDesignator().obj;
		int vel = velikalista.size();
		if (velikalista.size() != 0) {
			Obj pom = Tab.find(funcCall.getDesignator().getName());
			ArrayList<Struct> lista = velikalista.get(velikalista.size() - 1); // ovde sam dodala struct

			for (Obj ob : pom.getLocalSymbols()) {

				if (ob.getFpPos() <= lista.size() && ob.getFpPos() != 0) {

					if (lista.get(ob.getFpPos() - 1) != ob.getType()) {
						if (ob.getType().getKind() == lista.get(ob.getFpPos() - 1).getKind()
								&& ob.getType().getKind() == Struct.Array) {

							if (ob.getType().getElemType() != lista.get(ob.getFpPos() - 1).getElemType()) {
								report_error("greska na liniji " + funcCall.getLine()
										+ " nije prosledjen odgovarajuci tip argumenta", null);
							}
						} else {
							report_error("greska na liniji " + funcCall.getLine()
									+ " nije prosledjen odgovarajuci tip argumenta", null);
						}
					}
				}
			}
		}
		if (vel != 0) {
			velikalista.remove(vel - 1);
		}
		int size = paramlist.size() - 1;
		if (size < 0) {
			actParams = 0;
		} else {
			actParams = paramlist.get(size);
		}
		System.out.println(actParams + " " + func.getLevel());
		if (actParams != func.getLevel()) {
			report_error("Greska na liniji " + funcCall.getLine() + " : funkciji " + func.getName()
					+ " nije prosledjen odgovarajuvci broj parametara", null);
		} else {

			actParams = 0;
		}
		if (Obj.Meth == func.getKind()) {
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.struct = func.getType();
		} else {
			report_error("Greska na liniji " + funcCall.getLine() + " : ime " + func.getName() + " nije funkcija!",
					null);
			funcCall.struct = Tab.noType;
		}
		if (size >= 0) {
			paramlist.remove(size);
		}
		
	}
	
	
	
	
	
	
	
	
	
	

	public void visit(Designator designator) {
		Obj obj = Tab.find(designator.getName());
		if (obj == Tab.noObj) {
			report_error("Greska na liniji " + designator.getLine() + " : ime " + designator.getName()
					+ " nije deklarisano! ", null);
		} else {

		}
		designator.obj = obj;

		if (obj.getFpPos() != 0) {
			report_info("upotreba formalnog parametra " + designator.getName() + " na liniji " + designator.getLine(),
					null);
		} else {

			if (obj.getKind() == 0) {
				velniza=obj.getAdr();
				if (obj.getLevel() == 0) {
					report_info("upotreba globalne konstante " + designator.getName() + " na liniji "
							+ designator.getLine(), null);
				} else {
					report_info(
							"upotreba lokalne konstante " + designator.getName() + " na liniji " + designator.getLine(),
							null);
				}
			} else if (obj.getLevel() == 0) {
				report_info(
						"upotreba globalne promenljive " + designator.getName() + " na liniji " + designator.getLine(),
						null);
			} else {
				report_info(
						"upotreba lokalne promenljive " + designator.getName() + " na liniji " + designator.getLine(),
						null);
			}
		}

		if (tip == 1) {  //radi se o enumu
			boolean nasao = false;

			for (Obj o : obj.getType().getMembers()) {

				if (o.getName().equals(ime)) {
					nasao = true;
					designator.obj = o;
					break;
				}
			}
			if (!nasao) {
				report_error("ne postoji takva mogucnost u nabrajanju na liniji " + designator.getLine(), null);
			} else {
				velniza=designator.obj.getAdr();
			}
			
		}

		if (tip == 2) {
			if (obj.getType().getKind() != Struct.Array) {
				report_error("greska na liniji " + designator.getLine() + " " + designator.getName() + " nije niz",
						null);

			} else {

				designator.obj = new Obj(Obj.Elem, " ", obj.getType().getElemType(), obj.getAdr(), obj.getLevel());
			}

		}
		tip = 0;
	}

	public void visit(DesignatorPlus dp) {
		Obj obj = Tab.find(dp.getDesignator().getName());
		if (obj.getType() != Tab.intType || obj.getKind() == 0) {
			report_error("Greska na liniji " + dp.getLine()
					+ " Operator ++ se moze koristiti samo nad promenljivom tipa int", null);
		}
	}

	public void visit(DesignatorMinus dp) {
		Obj obj = Tab.find(dp.getDesignator().getName());
		if (obj.getType() != Tab.intType || obj.getKind() == 0) {
			report_error("Greska na liniji " + dp.getLine()
					+ " Operator -- se moze koristiti samo nad promenljivom tipa int", null);
		}
	}

	public void visit(DesignatorListSquare dls) {
		report_info("Pristup elementu niza " + " na liniji " + dls.getLine(), null);
		// dls.getLine(), null);
		tip = 2;
		if (dls.getExpr().struct != Tab.intType && dls.getExpr().struct.getKind() != 6) {
			report_error("Greska na liniji " + dls.getLine() + " Indeks mora biti integer", null);
		}

	}

	public void visit(ActualParam a) {
		a.struct = a.getExpr().struct;
		// actParams++;
		// Integer uzeto=paramlist.get(paramlist.size()-1);
		// uzeto++;
		Integer stavi = new Integer(1);
		paramlist.add(stavi);
		ArrayList lista = new ArrayList<Struct>();

		lista.add(a.struct);
		velikalista.add(lista);
	}

	public void visit(ActualParams a) {
		// actParams++;
		a.struct = a.getExpr().struct;
		Integer uzeto = paramlist.remove(paramlist.size() - 1);
		uzeto++;
		paramlist.add(uzeto);
		ArrayList lista = velikalista.get(velikalista.size() - 1);
		lista.add(a.struct);
	}

	public void visit(FormalParamDecl fpd) {
		// Obj obj = Tab.insert(Obj.Var, fpd.getParName(), fpd.getType().struct);
		int lev = currentMethod.getLevel();
		currentMethod.setLevel(++lev);
		// fpd.obj=new Obj(Obj.Var, fpd.getParName(), fpd.getType().struct, 0, 0 );
		// Tab.insert(fpd.obj);

		formPars = lev;

		if (isarray.remove(isarray.size() - 1) == 0) {
			report_info("Deklarisana promenljiva " + fpd.getParName(), fpd);
			Obj varNode = Tab.insert(Obj.Var, fpd.getParName(), fpd.getType().struct);
			varNode.setFpPos(lev);
		} else {
			report_info("Deklarisan niz " + fpd.getParName(), fpd);
			Obj varNode = Tab.insert(Obj.Var, fpd.getParName(), new Struct(Struct.Array, fpd.getType().struct));
			varNode.setFpPos(lev);
		}

	}

	public void visit(ChangeFor ff) {
		forovi++;
	}

	public void visit(For ff) {
		forovi--;
	}

	public void visit(ChangeBreak cb) {
		if (forovi == 0) {
			report_error("Greska na liniji " + cb.getLine() + " break se moze koristiti samo unutar for petlje", null);
		}
	}

	public void visit(Continue c) {
		if (forovi == 0) {
			report_error("Greska na liniji " + c.getLine() + " continue se moze koristiti samo unutar for petlje",
					null);
		}

	}

	public void visit(NTrue nt) {

		nt.struct = boolType;
	}

	public void visit(NFalse nt) {
		nt.struct = boolType;
	}

	public void visit(NRead re) {
		Obj obj = Tab.find(re.getDesignator().getName()); // ovo bzvz

		if (!(re.getDesignator().obj.getType() == Tab.charType || re.getDesignator().obj.getType() == Tab.intType
				|| re.getDesignator().obj.getType() == boolType)) {
			report_error("Nedozvoljen parametar funkcije read na liniji " + re.getLine(), null);
		}
	}

	/*
	 * public void visit(NPrint np) {
	 * 
	 * if (!(np.getExpr().struct == Tab.charType || np.getExpr().struct ==
	 * Tab.intType || np.getExpr().struct == boolType)) {
	 * report_error("Nedozvoljen tip argumenta prosledjen funkciji print na liniji "
	 * + np.getLine(), null); } }
	 */

	public void visit(NCondFact cf) {
		if (cf.getExpr().struct != cf.getExpr1().struct) {
			report_error("nekompatibilni tipovi za poredjenje na liniji " + cf.getLine(), null);
		}
	}

	public void visit(CondFactOne cfo) {
		if (cfo.getExpr().struct != boolType) {
			report_error("Greska! Uslov nije bool tipa na liniji " + cfo.getLine(), null);
		}
	}

	public void visit(ExprMinus em) {

		if (em.getTerm().struct != Tab.intType) {
			report_error("Greska na liniji " + em.getLine() + " tip izraza iza minusa nije int.", null);
		}
		em.struct = Tab.intType;
	}
	
	public void visit(Korencic em) {
		em.struct = Tab.intType;
	}


	public void visit(DesignatorListPoint dlp) {
		tip = 1;
		ime = dlp.getId();
		fleg = 1;
		
	}

	public void visit(NewBig nb) {
		if (nb.getExpr().struct != Tab.intType) {
			report_error("greska na liniji: " + nb.getLine() + " broj clanova niza mora biti integer ", null);
		}
		nb.struct = new Struct(Struct.Array, nb.getType().struct);

	}
	
	int treba=0;
	int ima=0;
	
	public void visit(NtHelpDerived1 ni) {
		
		if(ni.getExpr().struct!=Tab.intType) {
			report_error("greska na liniji: " + ni.getLine() + " broj clanova niza mora biti integer ", null);
		}
		ni.struct=new Struct(Struct.Array, ni.getType().struct);
		arrayType=new Struct(ni.struct.getElemType().getKind());
		
		treba=velniza;
		//tip=2;
		
		/*System.out.println("posetio");
		String src=ni.getExpr().toString();
		StringBuilder builder = new StringBuilder();
		    for (int i = 0; i < src.length(); i++) {
		        char c = src.charAt(i);
		        if (Character.isDigit(c)) {
		            builder.append(c);
		        }
		    }
		    System.out.println(builder.toString()+" src");
		    treba=Integer.parseInt(builder.toString());
		    ima=0;*/
	}
	
	public void visit(YesNewInitList y) {
		if(arrayType ==null) {
			System.out.println("null arej tipe");
		}
		if(y.getExpr().struct.getKind() != arrayType.getKind()) {
			report_error("greska na liniji: " + y.getLine() + " element i niz nisu istog tipa ", null);
		}
		ima++;
		
	}
	
	public void visit(NewInit ni) {
		ni.struct=new Struct(Struct.Array, lastType);
		
		if(treba!=ima) {
			report_error("greska na liniji: " + ni.getLine() + " broj elemenata niza nije odgovarajuci ", null);
		}
		ima=0;
	}
	
	public void visit(NoNewInitList n) {
		if(n.getExpr().struct.getKind() != arrayType.getKind()) {
			report_error("greska na liniji: " + n.getLine() + " element i niz nisu istog tipa ", null);
		}
		ima++;
	}

	public void visit(YesIdentList il) {
		if (isarray.remove(isarray.size() - 1) == 0) {
			report_info("Deklarisana promenljiva " + il.getVarName(), il);
			Obj varNode = Tab.insert(Obj.Var, il.getVarName(), lastType);
		} else {
			report_info("Deklarisan niz " + il.getVarName(), il);
			Obj varNode = Tab.insert(Obj.Var, il.getVarName(), new Struct(Struct.Array, lastType));
		}

		// Tab.insert(Obj.Var, il.getVarName(), lastType);
	}
	
	

	public void visit(YesConstList cl) {
		Obj o = Tab.insert(Obj.Con, cl.getVarName(), lastType);
		o.setAdr(brojeviconst.remove(brojeviconst.size() - 1));
	}

	public void visit(ExprFactor ef) {
		ef.struct = ef.getExpr().struct;
	}

	public boolean passed() {
		return !errorDetected;
	}

	public void visit(SubOp s) {
		System.out.println("posecen");
	}

	public void visit(True t) {
		t.struct = boolType;
	}

	public void visit(False t) {
		t.struct = boolType;
	}

	public void visit(YesSquares y) {
		isarray.add(1);
	}

	public void visit(NoSquares n) {
		isarray.add(0);
	}
	
	public void visit(Novo n) {
		tip = 2;
	}

}
