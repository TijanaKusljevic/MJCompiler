// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:38


package rs.ac.bg.etf.pp1.ast;

public class YesSquares extends Squares {

    public YesSquares () {
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
        buffer.append("YesSquares(\n");

        buffer.append(tab);
        buffer.append(") [YesSquares]");
        return buffer.toString();
    }
}
