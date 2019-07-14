// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class ChangeBreak extends Matched {

    private Change Change;

    public ChangeBreak (Change Change) {
        this.Change=Change;
        if(Change!=null) Change.setParent(this);
    }

    public Change getChange() {
        return Change;
    }

    public void setChange(Change Change) {
        this.Change=Change;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Change!=null) Change.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Change!=null) Change.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Change!=null) Change.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ChangeBreak(\n");

        if(Change!=null)
            buffer.append(Change.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ChangeBreak]");
        return buffer.toString();
    }
}
