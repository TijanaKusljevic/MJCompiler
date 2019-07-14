// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class NtSB extends NtSquareBrace {

    private NtSquareRight NtSquareRight;

    public NtSB (NtSquareRight NtSquareRight) {
        this.NtSquareRight=NtSquareRight;
        if(NtSquareRight!=null) NtSquareRight.setParent(this);
    }

    public NtSquareRight getNtSquareRight() {
        return NtSquareRight;
    }

    public void setNtSquareRight(NtSquareRight NtSquareRight) {
        this.NtSquareRight=NtSquareRight;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NtSquareRight!=null) NtSquareRight.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NtSquareRight!=null) NtSquareRight.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NtSquareRight!=null) NtSquareRight.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NtSB(\n");

        if(NtSquareRight!=null)
            buffer.append(NtSquareRight.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NtSB]");
        return buffer.toString();
    }
}
