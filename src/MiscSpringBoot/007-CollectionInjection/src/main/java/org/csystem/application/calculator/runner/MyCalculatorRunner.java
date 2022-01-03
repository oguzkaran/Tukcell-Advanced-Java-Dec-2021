package org.csystem.application.calculator.runner;

import org.csystem.application.calculator.calculator.ICalculator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCalculatorRunner implements ApplicationRunner {
    private final ICalculator m_calculator;

    public MyCalculatorRunner(@Qualifier("myCalculator") ICalculator calculator)
    {
        m_calculator = calculator;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_calculator.calculate();
    }
}
