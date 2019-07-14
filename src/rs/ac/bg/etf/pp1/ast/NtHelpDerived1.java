// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class NtHelpDerived1 extends NtHelp {

    private Type Type;
    private NtSquareLeft NtSquareLeft;
    private Expr Expr;
    private NtSquareBrace NtSquareBrace;

    public NtHelpDerived1 (Type Type, NtSquareLeft NtSquareLeft, Expr Expr, NtSquareBrace NtSquareBrace) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.NtSquareLeft=NtSquareLeft;
        if(NtSquareLeft!=null) NtSquareLeft.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.NtSquareBrace=NtSquareBrace;
        if(NtSquareBrace!=null) NtSquareBrace.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public NtSquareLeft getNtSquareLeft() {
        return NtSquareLeft;
    }

    public void setNtSquareLeft(NtSquareLeft NtSquareLeft) {
        this.NtSquareLeft=NtSquareLeft;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public NtSquareBrace getNtSquareBrace() {
        return NtSquareBrace;
    }

    public void setNtSquareBrace(NtSquareBrace NtSquareBrace) {
        this.NtSquareBrace=NtSquareBrace;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(NtSquareLeft!=null) NtSquareLeft.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(NtSquareBrace!=null) NtSquareBrace.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(NtSquareLeft!=null) NtSquareLeft.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(NtSquareBrace!=null) NtSquareBrace.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(NtSquareLeft!=null) NtSquareLeft.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(NtSquareBrace!=null) NtSquareBrace.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NtHelpDerived1(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NtSquareLeft!=null)
            buffer.append(NtSquareLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NtSquareBrace!=null)
            buffer.append(NtSquareBrace.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NtHelpDerived1]");
        return buffer.toString();
    }
}
