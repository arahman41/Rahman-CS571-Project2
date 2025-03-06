package src;

public interface ExprVisitor<R> {
    R visitPlusExpr(PlusExpr e);
    R visitMinusExpr(MinusExpr e);
    R visitTimesExpr(TimesExpr e);
    R visitDivExpr(DivExpr e);
    R visitFloatExpr(FloatExpr e);

}
