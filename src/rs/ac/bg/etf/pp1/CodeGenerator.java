package rs.ac.bg.etf.pp1;

import java.util.ArrayList;

import com.sun.javafx.geom.AreaOp.AddOp;
import com.sun.javafx.geom.AreaOp.SubOp;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	private int varCount;

	private int paramCnt;

	private int mainPc;
	private int operation = 0;
	
	private int uslovuforu=0;
	
	private int prvi=0;
	private int drugi=0;
	private int koji=0;
	private int cudno=0;

	private int poslednja = 0;
	private int adresa1 = 0;
	private int adresa4 = 0;
	private int fagain = 0;
	private int iagain = 0;
	private int badresa = 0;
	private int read = 0;
	private ArrayList<ArrayList<Integer>> breakad = new ArrayList<ArrayList<Integer>>(); // za break
	private ArrayList<Integer> badrese = new ArrayList<Integer>(); // za break
	private ArrayList<Integer> fadrese = new ArrayList<Integer>(); // pocetak uslova u foru
	private ArrayList<Integer> iadrese = new ArrayList<Integer>(); // da se skoci na i++, posle continue i kraja fora
																	// ide se tu
	private ArrayList<Integer> gadrese = new ArrayList<Integer>(); // nebitno
	private ArrayList<Integer> adrese = new ArrayList<Integer>(); // jedan uslov samo izmedju dav && && ili sam ili na
																	// kraju ||
	private ArrayList<ArrayList<Integer>> poslednje = new ArrayList<ArrayList<Integer>>(); // skakanje na kraj ifa,
																							// pocetak else, iskakanje
																							// iz fora, skok na next
																							// group and,
	private ArrayList<Integer> adrese2 = new ArrayList<Integer>(); // kraj nekog ili skace se na izvrsenje

	private ArrayList<Integer> adrese1 = new ArrayList<Integer>(); // ako niko nije tacan da skoci u else
	private ArrayList<Integer> adrese4 = new ArrayList<Integer>(); // zadnje ili, realno moze i bez njege dovoljne s

	private Obj designator1; // zbog niza {} da znam koji je niz u pitanju
	private Struct lastType;
	private int flegStore = 0; // kad je niz{}

	private int flegzagrade = 0; // da se designator ne poremeti kod niz{}

	public int getMainPc() {
		return mainPc;
	}

	@Override
	public void visit(MethodTypeName MethodTypeName) {
		if ("main".equalsIgnoreCase(MethodTypeName.getMethName())) {

			Obj o = Tab.find("len");
			o.setAdr(Code.pc);
			Code.put(Code.enter);
			Code.put(0);
			Code.put(0);

			Code.put(Code.arraylength);
			Code.put(Code.exit);
			Code.put(Code.return_);
			// System.out.println(Code.pc);

			Obj o1 = Tab.find("chr");
			o1.setAdr(Code.pc);

			Code.put(Code.enter);
			Code.put(0);
			Code.put(0);
			Code.put(Code.exit);
			Code.put(Code.return_);

			Obj o2 = Tab.find("ord");
			o2.setAdr(Code.pc);

			Code.put(Code.enter);
			Code.put(0);
			Code.put(0);
			Code.put(Code.exit);
			Code.put(Code.return_);

			mainPc = Code.pc;

		}
		MethodTypeName.obj.setAdr(Code.pc);

		// Collect arguments and local variables.
		SyntaxNode methodNode = MethodTypeName.getParent();
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);

		// Generate the entry.
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(varCnt.getCount() + fpCnt.getCount());
	}

	public void visit(MetodTypeVoid MethodTypeName) {
		if ("main".equalsIgnoreCase(MethodTypeName.getMethName())) {

			Obj o = Tab.find("len");
			o.setAdr(Code.pc);
			Code.put(Code.enter);
			Code.put(0);
			Code.put(0);

			Code.put(Code.arraylength);
			Code.put(Code.exit);
			Code.put(Code.return_);
			// System.out.println(Code.pc);

			Obj o1 = Tab.find("chr");
			o1.setAdr(Code.pc);

			Code.put(Code.enter);
			Code.put(0);
			Code.put(0);
			Code.put(Code.exit);
			Code.put(Code.return_);

			Obj o2 = Tab.find("ord");
			o2.setAdr(Code.pc);

			Code.put(Code.enter);
			Code.put(0);
			Code.put(0);
			Code.put(Code.exit);
			Code.put(Code.return_);

			mainPc = Code.pc;
		}
		MethodTypeName.obj.setAdr(Code.pc);

		// Collect arguments and local variables.
		SyntaxNode methodNode = MethodTypeName.getParent();
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);

		// Generate the entry.
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(varCnt.getCount() + fpCnt.getCount());
	}

	@Override
	public void visit(VarDecl VarDecl) {
		varCount++;
	}

	@Override
	public void visit(FormalParamDecl FormalParam) {
		paramCnt++;
	}

	@Override
	public void visit(Const Const) {
		Code.load(new Obj(Obj.Con, "$", Const.struct, Const.getN1(), 0));
		koji=Const.getN1();
	}

	@Override
	public void visit(MethodDecl MethodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	@Override
	public void visit(ReturnExpr ReturnExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	@Override
	public void visit(ReturnNoExpr ReturnNoExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	public void visit(Ternarni Assignment) {
		Code.put(Code.pop);
		if (Assignment.getDesignator().obj.getKind() == Obj.Elem) {
			if (Assignment.getDesignator().obj.getLevel() == 0) { // global variable
				Code.put(Code.getstatic);
				Code.put2(Assignment.getDesignator().obj.getAdr());
			} else {
				// local variable
				if (0 <= Assignment.getDesignator().obj.getAdr() && Assignment.getDesignator().obj.getAdr() <= 3)
					Code.put(Code.load_n + Assignment.getDesignator().obj.getAdr());
				else {
					Code.put(Code.load);
					Code.put(Assignment.getDesignator().obj.getAdr());
				}
			}
			Code.put(Code.dup_x2);
			Code.put(Code.pop);
		}
		if (flegStore == 0) {
			Code.store(Assignment.getDesignator().obj);
		} else {
			flegStore = 0; // vec su dodeljene vrednosti, ne treba sad opet
		}
	}
	
	@Override
	public void visit(Assignment Assignment) {

		if (Assignment.getDesignator().obj.getKind() == Obj.Elem) {
			if (Assignment.getDesignator().obj.getLevel() == 0) { // global variable
				Code.put(Code.getstatic);
				Code.put2(Assignment.getDesignator().obj.getAdr());
			} else {
				// local variable
				if (0 <= Assignment.getDesignator().obj.getAdr() && Assignment.getDesignator().obj.getAdr() <= 3)
					Code.put(Code.load_n + Assignment.getDesignator().obj.getAdr());
				else {
					Code.put(Code.load);
					Code.put(Assignment.getDesignator().obj.getAdr());
				}
			}
			Code.put(Code.dup_x2);
			Code.put(Code.pop);
		}
		if (flegStore == 0) {
			Code.store(Assignment.getDesignator().obj);
		} else {
			flegStore = 0; // vec su dodeljene vrednosti, ne treba sad opet
		}
	}

	@Override
	public void visit(Designator Designator) {
		SyntaxNode parent = Designator.getParent();
		if (Assignment.class != parent.getClass() && FuncCall.class != parent.getClass()
				&& DesignatorStatementList.class != parent.getClass()) {
			if (Designator.obj.getKind() == Obj.Elem) {
				if (Designator.obj.getLevel() == 0) { // global variable
					Code.put(Code.getstatic);
					Code.put2(Designator.obj.getAdr());
				} else {
					// local variable
					if (0 <= Designator.obj.getAdr() && Designator.obj.getAdr() <= 3)
						Code.put(Code.load_n + Designator.obj.getAdr());
					else {
						Code.put(Code.load);
						Code.put(Designator.obj.getAdr());
					}
				}
				if(cudno==0) {
					Code.put(Code.dup_x1);
					Code.put(Code.pop);
				}
			}
			if (read != 1 && cudno==0)
				Code.load(Designator.obj);
				
		}
		if (flegzagrade == 0) {
			designator1 = Designator.obj;
		}
		
		if(cudno==1) {
			cudno=0;
			//Code.put();
			Code.put(Code.dup_x2);
			Code.put(Code.pop);
			Code.put(Code.pop);
			
			for(int i=prvi; i<=drugi; i++) {
				Code.put(Code.dup2);
				Code.put(Code.aload);
				Code.put(Code.dup_x2);
				Code.put(Code.pop);
				Code.put(Code.const_1);
				Code.put(Code.add);
			}
			
			
			Code.put(Code.pop);
			Code.put(Code.pop);
			
			for(int i=prvi; i<drugi; i++) {
				Code.put(Code.add);
			}
		}
	}

	public void visit(FRead f) {
		read = 1;

	}

	@Override
	public void visit(FuncCall FuncCall) {
		Obj functionObj = FuncCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
	}

	public void visit(DesignatorStatementList FuncCall) {
		Obj functionObj = FuncCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		if (FuncCall.getDesignator().obj.getType() != Tab.noType) {
			Code.put(Code.pop);
		}
	}

	@Override
	public void visit(PrintStmt PrintStmt) {
		if (PrintStmt.getExpr().struct != Tab.charType) {
			Code.put(Code.const_5);
			Code.put(Code.print);
		} else {
			Code.put(Code.const_5);
			Code.put(Code.bprint);

		}
	}

	@Override
	public void visit(AddExpr addExpr) {
		if(addExpr.getAddop().getClass() == Tar.class) {
			Code.put(Code.dup);
			Code.put(Code.mul);
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
			Code.put(Code.dup);
			Code.put(Code.mul);
			Code.put(Code.const_3);
			Code.put(Code.mul);
			Code.put(Code.add);
			
		} else {
			if (addExpr.getAddop().getClass() == Addopplus.class) {
				Code.put(Code.add);
			} else {
				Code.put(Code.sub);
			}
		}
	}

	public void visit(DesignatorPlus p) {
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.store(p.getDesignator().obj);
	}

	public void visit(DesignatorMinus p) {
		Code.put(Code.const_m1);
		Code.put(Code.add);
		Code.store(p.getDesignator().obj);
	}

	public void visit(ExprMinus e) {
		Code.put(Code.neg);
	}

	public void visit(YesMulopList y) {
		if (y.getMulop().getClass() == Mul.class) {
			Code.put(Code.mul);
		} else {
			if (y.getMulop().getClass() == Div.class) {
				Code.put(Code.div);
			} else {
				Code.put(Code.rem);
			}
		}
	}

	public void visit(UnmatchedIf u) {

	}

	public void visit(CondFactOne cfo) {
		Code.put(Code.const_1);
		Code.putFalseJump(Code.eq, 0);
		adrese.add(new Integer(Code.pc - 2));
		System.out.println("cfo");

	}

	public void visit(NCondFact cf) {
		if (cf.getRelop().getClass() == EquEqu.class) {
			Code.putFalseJump(Code.eq, 0);
			adrese.add(new Integer(Code.pc - 2));
		}
		if (cf.getRelop().getClass() == NotEqu.class) {
			Code.putFalseJump(Code.ne, 0);
			adrese.add(new Integer(Code.pc - 2));
		}
		if (cf.getRelop().getClass() == Lessthen.class) {
			Code.putFalseJump(Code.lt, 0);
			adrese.add(new Integer(Code.pc - 2));
		}
		if (cf.getRelop().getClass() == Lessequal.class) {
			Code.putFalseJump(Code.le, 0);
			adrese.add(new Integer(Code.pc - 2));
		}
		if (cf.getRelop().getClass() == Greaterthen.class) {
			Code.putFalseJump(Code.gt, 0);
			adrese.add(new Integer(Code.pc - 2));
		}
		if (cf.getRelop().getClass() == Greaterequ.class) {
			Code.putFalseJump(Code.ge, 0);
			adrese.add(new Integer(Code.pc - 2));
		}
	}

	public void visit(FinishedIf f) {

		/*
		 * for (int i = 0; i < adrese.size(); i++) { int k = adrese.get(i);
		 * Code.fixup(k); System.out.println("uzeo");
		 * 
		 * }
		 */

		ArrayList<Integer> pom = poslednje.remove(poslednje.size() - 1);

		for (int i = 0; i < pom.size(); i++) {
			Code.fixup(pom.get(i));
		}
	}

	public void visit(StartElse se) {
		Code.putJump(0);
		adresa1 = Code.pc - 2;
		System.out.println(adresa1 + " adresa1");
		adrese1.add(adresa1);
		int size = poslednje.size();
		System.out.println(size + " opaa");
		ArrayList<Integer> pom = poslednje.remove(size - 1);
		// for(int i=0; i<adrese.size(); i++) {
		// Code.fixup(adrese.get(i));
		// }
		for (int i = 0; i < pom.size(); i++) {
			Code.fixup(pom.get(i));
		}
	}

	public void visit(ForStartDerived1 f) {
		for (int i = 0; i < adrese2.size(); i++) {
			Code.fixup(adrese2.get(i));
			System.out.println("fs");
		}
		adrese2 = new ArrayList<Integer>();

		badrese = new ArrayList<Integer>();
		breakad.add(badrese);

	}

	public void visit(ConditionForStartDerived1 f) {

		fagain = Code.pc;
		fadrese.add(fagain);
		
	}
	
	public void visit(YesConditionFor y) {
		uslovuforu=1;
	}
	
	public void visit(NoConditionFor n) {
		Code.putJump(0);
		adrese2.add(Code.pc-2);
	}

	public void visit(ForStatementStartDerived1 f) {
		iagain = Code.pc;
		iadrese.add(iagain);

		// System.out.println(cadrese.size()+" gledaj");
		// for(int i=0; i<cadrese.size(); i++) {
		// Code.fixup(cadrese.get(i));
		// }
	}

	public void visit(ForEnd f) {
		Code.putJump(iadrese.remove(iadrese.size() - 1));
		// breakad.add(badrese);
		// continuead.add(cadrese);
	}

	public void visit(ForStatementEndDerived1 f) {
		System.out.println(fadrese.get(fadrese.size() - 1));
		Code.putJump(fadrese.remove(fadrese.size() - 1));
		
	}

	public void visit(GetOutDerived1 g) {
		int size = poslednje.size() - 1;
		System.out.println("size "+size);
		if (size >= 0) {
			System.out.println("novi if");
			ArrayList<Integer> pom = poslednje.get(poslednje.size() - 1);
			poslednje.remove(size);
			for (int i = 0; i < pom.size(); i++) {
				int k = pom.get(i);
				Code.fixup(k);
				System.out.println("novi if popravka");
			}
		}
		gadrese.add(Code.pc);
		System.out.println(breakad.size() + " vel break adr");
		int uz = breakad.size() - 1;
		ArrayList<Integer> pom1 = breakad.remove(uz);
		for (int i = 0; i < pom1.size(); i++) {
			Code.fixup(pom1.get(i));
			System.out.println(pom1.get(i) + " pom1.get(i)");
		}

		uz = breakad.size() - 1;
		if (uz > -1)
			badrese = breakad.get(uz);
	}

	public void visit(Break b) {
		Code.putJump(0);
		badresa = Code.pc - 2;
		badrese.add(badresa);
	}

	public void visit(Continue c) {
		Code.putJump(iadrese.get(iadrese.size() - 1));
		System.out.println(iadrese.size() + " ovooo" + iadrese.get(0));
		// cadrese.add(Code.pc-2);
	}

	public void visit(StartIfDerived1 ni) {
		for (int i = 0; i < adrese2.size(); i++) {
			Code.fixup(adrese2.get(i));
		}
		adrese2 = new ArrayList<Integer>();
		int size = adrese4.size();
		adresa4 = adrese4.remove(size - 1);
		Code.fixup(adresa4);
		System.out.println("fixup ");
	}

	public void visit(EndElse ee) {
		int size = adrese1.size();
		Code.fixup(adrese1.get(size - 1));
		adrese1.remove(size - 1);
	}

	public void visit(ConditionEndDerived1 ce) {
		Code.putJump(0);
		adresa4 = Code.pc - 2;
		adrese4.add(adresa4);
		// System.out.println(adresa4);
		System.out.println("adresa4 " + adresa4);
	}

	public void visit(NextGroupAndDerived1 nga) {
		int size = poslednje.size() - 1;
		ArrayList<Integer> pom = poslednje.get(poslednje.size() - 1);
		poslednje.remove(size);
		// for(int i=0; i<adrese.size(); i++) {
		// int k=adrese.get(i);
		// Code.fixup(k);
		// }
		System.out.println("nga");
		for (int i = 0; i < pom.size(); i++) {
			int k = pom.get(i);
			Code.fixup(k);
		}

	}

	public void visit(EndCondTermDerived1 ect) {
		System.out.println(adrese.size() + " adrese.size()");
		poslednje.add(adrese);
		System.out.println(adrese.toString());
		adrese = new ArrayList<Integer>();

	}

	public void visit(CondTerm ct) {
		Code.putJump(0);
		System.out.println("adresa2 " + (Code.pc - 2));
		adrese2.add(Code.pc - 2);
	}

	public void visit(EndCondFor ecf) {
		System.out.println("u fji");
		if (uslovuforu == 0) {
			System.out.println("prazne"+ adrese.size());
			poslednje.add(adrese);
		}
		uslovuforu=0;

	}

	public void visit(NewBig nb) {
		Code.put(Code.newarray);
		if (nb.getType().struct == Tab.charType) {
			Code.put(0);
		} else {
			Code.put(1);
		}
	}

	public void visit(NtSB nt) {
		Code.put(Code.newarray);
		if (lastType == Tab.charType) {
			Code.put(0);
		} else {
			Code.put(1);
		}
		flegStore = 1;
		Code.store(designator1);
	}

	int ind = 0;

	public void visit(NoNewInitList y) {
		ind = 0;
		if (designator1.getLevel() == 0) { // global variable
			Code.put(Code.getstatic);
			Code.put2(designator1.getAdr());
		} else {
			// local variable
			if (0 <= designator1.getAdr() && designator1.getAdr() <= 3)
				Code.put(Code.load_n + designator1.getAdr());
			else {
				Code.put(Code.load);
				Code.put(designator1.getAdr());
			}
		}

		Code.put(Code.const_1);
		Code.put(Code.const_m1);
		Code.put(Code.add);

		ind++;

		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);

		if (lastType == Tab.intType)
			Code.put(Code.astore);
		else
			Code.put(Code.bastore);

	}

	public void visit(YesNewInitList y) {
		if (designator1.getLevel() == 0) { // global variable
			Code.put(Code.getstatic);
			Code.put2(designator1.getAdr());
		} else {
			// local variable
			if (0 <= designator1.getAdr() && designator1.getAdr() <= 3)
				Code.put(Code.load_n + designator1.getAdr());
			else {
				Code.put(Code.load);
				Code.put(designator1.getAdr());
			}
		}

		if (1 <= ind && ind <= 5)
			Code.put(Code.const_n + ind);
		else if (ind == -1)
			Code.put(Code.const_m1);
		else {
			Code.put(Code.const_);
			Code.put4(ind);
		}
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);

		if (lastType == Tab.intType)
			Code.put(Code.astore);
		else
			Code.put(Code.bastore);

		ind++;
	}

	public void visit(NRead n) {

		if (n.getDesignator().obj.getType() != Tab.charType) {
			Code.put(Code.read);
			Code.store(n.getDesignator().obj);
		} else {
			Code.put(Code.bread);
			Code.store(n.getDesignator().obj);
		}
		read = 0;
	}

	public void visit(CharConst c) {
		Code.load(new Obj(Obj.Con, "$", c.struct, c.getC1(), 0));

	}

	public void visit(True t) {
		Code.load(new Obj(Obj.Con, "$", t.struct, 1, 0));
	}

	public void visit(False t) {
		Code.load(new Obj(Obj.Con, "$", t.struct, 0, 0));
	}

	public void visit(Type t) {
		lastType = t.struct;
	}

	public void visit(NtSquareL n) {
		flegzagrade = 1;
	}

	public void visit(NtSquareR n) {
		flegzagrade = 0;
	}
	
	public void visit(Novo n) {
		cudno=1;
	}
	
	public void visit(NtL n) {
		prvi=koji;
	}
	
	public void visit(NtD n) {
		drugi=koji;
	}
	
	public void visit(Korencic k) {
		Code.put(Code.dup);
		Code.put(Code.const_1);
		Code.put(Code.dup_x1);
		Code.put(Code.const_1);
		Code.put(Code.mul);
		int adresa2=Code.pc;
		Code.putFalseJump(Code.ge, 0);
		int adrs=Code.pc-2;
		System.out.println(adrs);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.put(Code.dup2);
		Code.put(Code.dup);
		Code.put(Code.mul);
		Code.putJump(adresa2);	
		Code.fixup(adrs);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		Code.put(Code.pop);
		Code.put(Code.const_1);
		Code.put(Code.sub);
		
	}
}
