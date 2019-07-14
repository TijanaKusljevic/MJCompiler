// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class YesOrConditionList extends OrConditionList {

    private OrConditionList OrConditionList;
    private NextGroupAnd NextGroupAnd;
    private CondTerm CondTerm;

    public YesOrConditionList (OrConditionList OrConditionList, NextGroupAnd NextGroupAnd, CondTerm CondTerm) {
        this.OrConditionList=OrConditionList;
        if(OrConditionList!=null) OrConditionList.setParent(this);
        this.NextGroupAnd=NextGroupAnd;
        if(NextGroupAnd!=null) NextGroupAnd.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public OrConditionList getOrConditionList() {
        return OrConditionList;
    }

    public void setOrConditionList(OrConditionList OrConditionList) {
        this.OrConditionList=OrConditionList;
    }

    public NextGroupAnd getNextGroupAnd() {
        return NextGroupAnd;
    }

    public void setNextGroupAnd(NextGroupAnd NextGroupAnd) {
        this.NextGroupAnd=NextGroupAnd;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OrConditionList!=null) OrConditionList.accept(visitor);
        if(NextGroupAnd!=null) NextGroupAnd.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OrConditionList!=null) OrConditionList.traverseTopDown(visitor);
        if(NextGroupAnd!=null) NextGroupAnd.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OrConditionList!=null) OrConditionList.traverseBottomUp(visitor);
        if(NextGroupAnd!=null) NextGroupAnd.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesOrConditionList(\n");

        if(OrConditionList!=null)
            buffer.append(OrConditionList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NextGroupAnd!=null)
            buffer.append(NextGroupAnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesOrConditionList]");
        return buffer.toString();
    }
}
