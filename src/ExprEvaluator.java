package src;

class ExprEvaluator implements ExprVisitor<Float> {
    @Override
    public Float visitPlusExpr(PlusExpr e) {
        return e.getE1().accept(this) + e.getE2().accept(this);
    }

    @Override
    public Float visitMinusExpr(MinusExpr e) {
        return e.getE1().accept(this) - e.getE2().accept(this);
    }

    @Override
    public Float visitTimesExpr(TimesExpr e) {
        return e.getE1().accept(this) * e.getE2().accept(this);
    }

    @Override
    public Float visitDivExpr(DivExpr e) {
        float denominator = e.getE2().accept(this);
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return e.getE1().accept(this) / denominator;
    }

    @Override
    public Float visitFloatExpr(FloatExpr e) {
        return e.getLiteral();
    }
}
