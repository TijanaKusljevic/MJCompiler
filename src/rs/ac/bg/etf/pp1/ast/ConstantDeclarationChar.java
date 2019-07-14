// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:38


package rs.ac.bg.etf.pp1.ast;

public class ConstantDeclarationChar extends ConstDecl {

    private char C1;

    public ConstantDeclarationChar (char C1) {
        this.C1=C1;
    }

    public char getC1() {
        return C1;
    }

    public void setC1(char C1) {
        this.C1=C1;
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
        buffer.append("ConstantDeclarationChar(\n");

        buffer.append(" "+tab+C1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantDeclarationChar]");
        return buffer.toString();
    }
}
