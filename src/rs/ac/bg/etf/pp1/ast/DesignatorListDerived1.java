// generated with ast extension for cup
// version 0.8
// 28/0/2019 15:34:32


package rs.ac.bg.etf.pp1.ast;

public class DesignatorListDerived1 extends DesignatorList {

    public DesignatorListDerived1 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorListDerived1(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorListDerived1]");
        return buffer.toString();
    }
}
