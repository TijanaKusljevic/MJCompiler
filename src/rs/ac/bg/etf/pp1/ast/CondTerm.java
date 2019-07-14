// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class CondTerm implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private CondFact CondFact;
    private AndConditionList AndConditionList;
    private EndCondTerm EndCondTerm;

    public CondTerm (CondFact CondFact, AndConditionList AndConditionList, EndCondTerm EndCondTerm) {
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
        this.AndConditionList=AndConditionList;
        if(AndConditionList!=null) AndConditionList.setParent(this);
        this.EndCondTerm=EndCondTerm;
        if(EndCondTerm!=null) EndCondTerm.setParent(this);
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public AndConditionList getAndConditionList() {
        return AndConditionList;
    }

    public void setAndConditionList(AndConditionList AndConditionList) {
        this.AndConditionList=AndConditionList;
    }

    public EndCondTerm getEndCondTerm() {
        return EndCondTerm;
    }

    public void setEndCondTerm(EndCondTerm EndCondTerm) {
        this.EndCondTerm=EndCondTerm;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFact!=null) CondFact.accept(visitor);
        if(AndConditionList!=null) AndConditionList.accept(visitor);
        if(EndCondTerm!=null) EndCondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
        if(AndConditionList!=null) AndConditionList.traverseTopDown(visitor);
        if(EndCondTerm!=null) EndCondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        if(AndConditionList!=null) AndConditionList.traverseBottomUp(visitor);
        if(EndCondTerm!=null) EndCondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTerm(\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AndConditionList!=null)
            buffer.append(AndConditionList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EndCondTerm!=null)
            buffer.append(EndCondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTerm]");
        return buffer.toString();
    }
}
