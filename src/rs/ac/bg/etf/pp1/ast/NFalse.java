// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class NFalse extends Factor {

    private NtFalse NtFalse;

    public NFalse (NtFalse NtFalse) {
        this.NtFalse=NtFalse;
        if(NtFalse!=null) NtFalse.setParent(this);
    }

    public NtFalse getNtFalse() {
        return NtFalse;
    }

    public void setNtFalse(NtFalse NtFalse) {
        this.NtFalse=NtFalse;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NtFalse!=null) NtFalse.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NtFalse!=null) NtFalse.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NtFalse!=null) NtFalse.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NFalse(\n");

        if(NtFalse!=null)
            buffer.append(NtFalse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NFalse]");
        return buffer.toString();
    }
}
