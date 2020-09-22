package com.fetch.pyramid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;

import java.net.URL;
import java.util.*;
import com.fetch.pyramid.models.*;



/**
 * The Entry point of all the incoming requests.It has two endpoints
 * /outliers?threshold=  and /outliers/<clustername>/?threshold=
 */
@RestController
public class PyramidController {

    @RequestMapping(value = "/pyramid/validate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public PyramidOutput validatePyramid(PyramidInput input) throws Exception{
          boolean out = this.isPyramid(input.getInput());
          return new PyramidOutput(out);
    }

    private boolean isPyramid(String word){
      if(word == null || word.length() == 0)
        return false;
      Map<Character, Integer> map = new HashMap<>();
    for(char ch : word.toCharArray()) {
       map.put(ch, map.getOrDefault(ch, 0) + 1);
   }

 List<Integer> list = new ArrayList<>(map.values());
 Collections.sort(list);

 for(int i = 1; i <= list.size();i++) {
   if(list.get(i-1) != i)
     return false;
 }

 return true;
    }

}
