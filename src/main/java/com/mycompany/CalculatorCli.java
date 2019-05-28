/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

//import static com.sun.javafx.util.Utils.split;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.DoubleConsumer;
import java.util.stream.Stream;
//import static jdk.nashorn.internal.objects.NativeString.split;

/**
 *
 * @author user
 */
public class CalculatorCli {
  private final Calculator calculator;
  
  public CalculatorCli(Calculator calculator){
      this.calculator = calculator;
  }
  public void runInteractiveSession(Reader reader){
      runInteractiveSession(reader, System.out::println);
  }
 public void runInteractiveSession(Reader reader, DoubleConsumer resultConsumer){
     new BufferedReader(reader).lines()
       .flatMap(s -> Stream.of(s.split(";")))
       .filter(s -> !s.trim().isEmpty())
        .mapToDouble(calculator::calculate)
        .forEach(resultConsumer);
 }
 public static void main(String[] args) throws Exception {
   CalculatorCli calculatorCli = new CalculatorCli(new CalculatorImp());
   try (Reader reader = new InputStreamReader(System.in)){
    calculatorCli.runInteractiveSession(reader);
   }
 }
}
