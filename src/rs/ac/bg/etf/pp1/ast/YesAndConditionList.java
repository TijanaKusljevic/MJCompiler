// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class YesAndConditionList extends AndConditionList {

    private AndConditionList AndConditionList;
    private CondFact CondFact;

    public YesAndConditionList (AndConditionList AndConditionList, CondFact CondFact) {
        this.AndConditionList=AndConditionList;
        if(AndConditionList!=null) AndConditionList.setParent(this);
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
    }

    public AndConditionList getAndConditionList() {
        return AndConditionList;
    }

    public void setAndConditionList(AndConditionList AndConditionList) {
        this.AndConditionList=AndConditionList;
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AndConditionList!=null) AndConditionList.accept(visitor);
        if(CondFact!=null) CondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AndConditionList!=null) AndConditionList.traverseTopDown(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AndConditionList!=null) AndConditionList.traverseBottomUp(visitor);
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesAndConditionList(\n");

        if(AndConditionList!=null)
            buffer.append(AndConditionList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesAndConditionList]");
        return buffer.toString();
    }
}
