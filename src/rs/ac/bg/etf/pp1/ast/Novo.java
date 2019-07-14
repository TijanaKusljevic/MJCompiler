// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class Novo extends DesignatorList {

    private NtLev NtLev;
    private NtDes NtDes;

    public Novo (NtLev NtLev, NtDes NtDes) {
        this.NtLev=NtLev;
        if(NtLev!=null) NtLev.setParent(this);
        this.NtDes=NtDes;
        if(NtDes!=null) NtDes.setParent(this);
    }

    public NtLev getNtLev() {
        return NtLev;
    }

    public void setNtLev(NtLev NtLev) {
        this.NtLev=NtLev;
    }

    public NtDes getNtDes() {
        return NtDes;
    }

    public void setNtDes(NtDes NtDes) {
        this.NtDes=NtDes;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NtLev!=null) NtLev.accept(visitor);
        if(NtDes!=null) NtDes.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NtLev!=null) NtLev.traverseTopDown(visitor);
        if(NtDes!=null) NtDes.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NtLev!=null) NtLev.traverseBottomUp(visitor);
        if(NtDes!=null) NtDes.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Novo(\n");

        if(NtLev!=null)
            buffer.append(NtLev.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NtDes!=null)
            buffer.append(NtDes.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Novo]");
        return buffer.toString();
    }
}
