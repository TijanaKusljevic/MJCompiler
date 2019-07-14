// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class Read extends Matched {

    private NtRead NtRead;

    public Read (NtRead NtRead) {
        this.NtRead=NtRead;
        if(NtRead!=null) NtRead.setParent(this);
    }

    public NtRead getNtRead() {
        return NtRead;
    }

    public void setNtRead(NtRead NtRead) {
        this.NtRead=NtRead;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NtRead!=null) NtRead.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NtRead!=null) NtRead.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NtRead!=null) NtRead.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Read(\n");

        if(NtRead!=null)
            buffer.append(NtRead.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Read]");
        return buffer.toString();
    }
}
