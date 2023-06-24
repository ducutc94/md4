package com.example.minitest.fommater;

import com.example.minitest.model.Class;
import com.example.minitest.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class ClassFormatter implements Formatter<Class> {
    private IClassService classService;

    @Autowired
    public ClassFormatter(IClassService classService){
        this.classService = classService;
    }

    @Override
    public Class parse(String text, Locale locale) throws ParseException {
        Class aClass = classService.findByID(Long.parseLong(text));
        return aClass;
    }

    @Override
    public String print(Class object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
