// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:38


package rs.ac.bg.etf.pp1.ast;

public class UnmatchedIf extends Unmatched {

    private NonterminalIf NonterminalIf;
    private Condition Condition;
    private StartIf StartIf;
    private Statement Statement;
    private FinishedIf FinishedIf;

    public UnmatchedIf (NonterminalIf NonterminalIf, Condition Condition, StartIf StartIf, Statement Statement, FinishedIf FinishedIf) {
        this.NonterminalIf=NonterminalIf;
        if(NonterminalIf!=null) NonterminalIf.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.StartIf=StartIf;
        if(StartIf!=null) StartIf.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.FinishedIf=FinishedIf;
        if(FinishedIf!=null) FinishedIf.setParent(this);
    }

    public NonterminalIf getNonterminalIf() {
        return NonterminalIf;
    }

    public void setNonterminalIf(NonterminalIf NonterminalIf) {
        this.NonterminalIf=NonterminalIf;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public StartIf getStartIf() {
        return StartIf;
    }

    public void setStartIf(StartIf StartIf) {
        this.StartIf=StartIf;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public FinishedIf getFinishedIf() {
        return FinishedIf;
    }

    public void setFinishedIf(FinishedIf FinishedIf) {
        this.FinishedIf=FinishedIf;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NonterminalIf!=null) NonterminalIf.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(StartIf!=null) StartIf.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(FinishedIf!=null) FinishedIf.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NonterminalIf!=null) NonterminalIf.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(StartIf!=null) StartIf.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(FinishedIf!=null) FinishedIf.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NonterminalIf!=null) NonterminalIf.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(StartIf!=null) StartIf.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(FinishedIf!=null) FinishedIf.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedIf(\n");

        if(NonterminalIf!=null)
            buffer.append(NonterminalIf.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StartIf!=null)
            buffer.append(StartIf.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FinishedIf!=null)
            buffer.append(FinishedIf.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedIf]");
        return buffer.toString();
    }
}
