
import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;

public class FindingPi {
  
 static Random random = new Random();
 
 public static double xyVal() {
  return random.nextDouble();
 }
 
 public static double distance(double xVal, double yVal) {
  return Math.sqrt(xVal*xVal+yVal*yVal);
 }
 
 public static double estimatePi(double numInside, double numTotal) {
   return 4.0*(numInside/numTotal);
 }
 
 public static double standardDeviation(ArrayList<Double> numArray) {
   double sum = 0.0;
   double SD = 0.0;
   int size = numArray.size();
   
   for (double num : numArray) {
     sum += num;
   }
   
   double mean = sum/size;
   
   for (double num : numArray) {
     SD += Math.pow(num-mean, 2);
   }
   
   return Math.sqrt(SD/size);
 }
 
 public static void main(String[] args) {
  double numInside = 0.0;
  double numTotal = 0.0;
  double averageEstimate = 0.0;
  int darts = 1000;
  int games = 100000;
  ArrayList<Double> numArray = new ArrayList<Double>(10);
  for (int i=0; i<games; i++) {
    //for (int j=0; j<darts;j++) {
      double xval = xyVal();
      double yval = xyVal();
      double dist = distance(xval, yval);
      if (dist <= 1.0) {
        numInside = numInside + 1.0;
      }
      numTotal = numTotal + 1.0;
    //}
    double piEstimate = estimatePi(numInside, numTotal);
    //System.out.println(piEstimate);
    numArray.add(i, piEstimate);
    averageEstimate += piEstimate;
  }
  averageEstimate /= (double) games;
  System.out.println(averageEstimate);
  System.out.println(standardDeviation(numArray));
 }
 
}
