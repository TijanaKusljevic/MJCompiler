// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class NewInit extends Factor {

    private NtHelp NtHelp;
    private NtNewInit NtNewInit;

    public NewInit (NtHelp NtHelp, NtNewInit NtNewInit) {
        this.NtHelp=NtHelp;
        if(NtHelp!=null) NtHelp.setParent(this);
        this.NtNewInit=NtNewInit;
        if(NtNewInit!=null) NtNewInit.setParent(this);
    }

    public NtHelp getNtHelp() {
        return NtHelp;
    }

    public void setNtHelp(NtHelp NtHelp) {
        this.NtHelp=NtHelp;
    }

    public NtNewInit getNtNewInit() {
        return NtNewInit;
    }

    public void setNtNewInit(NtNewInit NtNewInit) {
        this.NtNewInit=NtNewInit;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NtHelp!=null) NtHelp.accept(visitor);
        if(NtNewInit!=null) NtNewInit.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NtHelp!=null) NtHelp.traverseTopDown(visitor);
        if(NtNewInit!=null) NtNewInit.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NtHelp!=null) NtHelp.traverseBottomUp(visitor);
        if(NtNewInit!=null) NtNewInit.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NewInit(\n");

        if(NtHelp!=null)
            buffer.append(NtHelp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NtNewInit!=null)
            buffer.append(NtNewInit.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NewInit]");
        return buffer.toString();
    }
}
