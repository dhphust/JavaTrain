package designMode.factory.chatSimpleFactory;

public class ChartFactory {

    public static Chart getChart(String type){
        Chart chart = null;
        if (type.equals("histogram")) {
            chart = new HistogramChart();
        } else if (type.equals("line")) {
            chart = new LineChart();
        } else if (type.equals("pie")) {
            chart = new PieChart();
        }
        return chart;
    }

    public static void main(String[] args) {
        String type = "line1";
            Chart chart = ChartFactory.getChart(type);
            chart.display();
    }
}
