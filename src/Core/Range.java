package Core;

public class Range {
    private double min;
    private double max;

    public Range(double min, double max)
    {
        this.min = min;
        this.max = max;
    }

    public double map(double value, Range newRange)
    {
        double result;

        if (rangeOfValues() == 0)
            result = newRange.getMin();
        else
        {
            result = (((value - getMin()) * newRange.rangeOfValues()) / rangeOfValues()) + newRange.getMin();
        }

        return result;
    }

    private double rangeOfValues()
    {
        return getMax() - getMin();
    }

    public double getMin()
    {
        return min;
    }
    public void setMin(double min)
    {
        this.min = min;
    }
    public double getMax() {
        return max;
    }
    public void setMax(double max)
    {
        this.max = max;
    }
}
