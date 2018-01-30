package com.cap.jumpthequeue.general.service.impl.rest;


import io.oasp.module.rest.service.impl.json.ObjectMapperFactory;

import javax.inject.Named;

import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * The MappingFactory class to resolve polymorphic conflicts within the JumpTheQueue application.
 *
 */
@Named("ApplicationObjectMapperFactory")
public class ApplicationObjectMapperFactory extends ObjectMapperFactory {

  /**
   * The constructor.
   */
  public ApplicationObjectMapperFactory() {

    super();
    // register polymorphic base classes
    

    NamedType[] subtypes;
    // register mapping for polymorphic sub-classes
    
  }
}
