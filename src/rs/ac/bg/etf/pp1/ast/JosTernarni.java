// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class JosTernarni extends DesignatorStatement {

    private Condition Condition;
    private StartIf StartIf;
    private Expr Expr;
    private StartElse StartElse;
    private Expr Expr1;
    private EndElse EndElse;

    public JosTernarni (Condition Condition, StartIf StartIf, Expr Expr, StartElse StartElse, Expr Expr1, EndElse EndElse) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.StartIf=StartIf;
        if(StartIf!=null) StartIf.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.StartElse=StartElse;
        if(StartElse!=null) StartElse.setParent(this);
        this.Expr1=Expr1;
        if(Expr1!=null) Expr1.setParent(this);
        this.EndElse=EndElse;
        if(EndElse!=null) EndElse.setParent(this);
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public StartIf getStartIf() {
        return StartIf;
    }

    public void setStartIf(StartIf StartIf) {
        this.StartIf=StartIf;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public StartElse getStartElse() {
        return StartElse;
    }

    public void setStartElse(StartElse StartElse) {
        this.StartElse=StartElse;
    }

    public Expr getExpr1() {
        return Expr1;
    }

    public void setExpr1(Expr Expr1) {
        this.Expr1=Expr1;
    }

    public EndElse getEndElse() {
        return EndElse;
    }

    public void setEndElse(EndElse EndElse) {
        this.EndElse=EndElse;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Condition!=null) Condition.accept(visitor);
        if(StartIf!=null) StartIf.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(StartElse!=null) StartElse.accept(visitor);
        if(Expr1!=null) Expr1.accept(visitor);
        if(EndElse!=null) EndElse.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(StartIf!=null) StartIf.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(StartElse!=null) StartElse.traverseTopDown(visitor);
        if(Expr1!=null) Expr1.traverseTopDown(visitor);
        if(EndElse!=null) EndElse.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(StartIf!=null) StartIf.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(StartElse!=null) StartElse.traverseBottomUp(visitor);
        if(Expr1!=null) Expr1.traverseBottomUp(visitor);
        if(EndElse!=null) EndElse.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("JosTernarni(\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StartIf!=null)
            buffer.append(StartIf.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StartElse!=null)
            buffer.append(StartElse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr1!=null)
            buffer.append(Expr1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EndElse!=null)
            buffer.append(EndElse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [JosTernarni]");
        return buffer.toString();
    }
}
