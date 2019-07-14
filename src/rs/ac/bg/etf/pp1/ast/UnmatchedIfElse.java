// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:38


package rs.ac.bg.etf.pp1.ast;

public class UnmatchedIfElse extends Unmatched {

    private NonterminalIf NonterminalIf;
    private Condition Condition;
    private StartIf StartIf;
    private Matched Matched;
    private StartElse StartElse;
    private Unmatched Unmatched;
    private EndElse EndElse;

    public UnmatchedIfElse (NonterminalIf NonterminalIf, Condition Condition, StartIf StartIf, Matched Matched, StartElse StartElse, Unmatched Unmatched, EndElse EndElse) {
        this.NonterminalIf=NonterminalIf;
        if(NonterminalIf!=null) NonterminalIf.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.StartIf=StartIf;
        if(StartIf!=null) StartIf.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
        this.StartElse=StartElse;
        if(StartElse!=null) StartElse.setParent(this);
        this.Unmatched=Unmatched;
        if(Unmatched!=null) Unmatched.setParent(this);
        this.EndElse=EndElse;
        if(EndElse!=null) EndElse.setParent(this);
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

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public StartElse getStartElse() {
        return StartElse;
    }

    public void setStartElse(StartElse StartElse) {
        this.StartElse=StartElse;
    }

    public Unmatched getUnmatched() {
        return Unmatched;
    }

    public void setUnmatched(Unmatched Unmatched) {
        this.Unmatched=Unmatched;
    }

    public EndElse getEndElse() {
        return EndElse;
    }

    public void setEndElse(EndElse EndElse) {
        this.EndElse=EndElse;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NonterminalIf!=null) NonterminalIf.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(StartIf!=null) StartIf.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
        if(StartElse!=null) StartElse.accept(visitor);
        if(Unmatched!=null) Unmatched.accept(visitor);
        if(EndElse!=null) EndElse.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NonterminalIf!=null) NonterminalIf.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(StartIf!=null) StartIf.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
        if(StartElse!=null) StartElse.traverseTopDown(visitor);
        if(Unmatched!=null) Unmatched.traverseTopDown(visitor);
        if(EndElse!=null) EndElse.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NonterminalIf!=null) NonterminalIf.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(StartIf!=null) StartIf.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        if(StartElse!=null) StartElse.traverseBottomUp(visitor);
        if(Unmatched!=null) Unmatched.traverseBottomUp(visitor);
        if(EndElse!=null) EndElse.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedIfElse(\n");

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

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StartElse!=null)
            buffer.append(StartElse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Unmatched!=null)
            buffer.append(Unmatched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EndElse!=null)
            buffer.append(EndElse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedIfElse]");
        return buffer.toString();
    }
}
