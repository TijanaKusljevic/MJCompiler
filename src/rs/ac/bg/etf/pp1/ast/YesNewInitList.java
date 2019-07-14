// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class YesNewInitList extends NtNewInit {

    private NtNewInit NtNewInit;
    private Expr Expr;

    public YesNewInitList (NtNewInit NtNewInit, Expr Expr) {
        this.NtNewInit=NtNewInit;
        if(NtNewInit!=null) NtNewInit.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public NtNewInit getNtNewInit() {
        return NtNewInit;
    }

    public void setNtNewInit(NtNewInit NtNewInit) {
        this.NtNewInit=NtNewInit;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NtNewInit!=null) NtNewInit.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NtNewInit!=null) NtNewInit.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NtNewInit!=null) NtNewInit.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesNewInitList(\n");

        if(NtNewInit!=null)
            buffer.append(NtNewInit.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesNewInitList]");
        return buffer.toString();
    }
}
