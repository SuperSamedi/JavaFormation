package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Tag à donner à un type pour la différencier.
@Target( {ElementType.TYPE} )
@Retention(RetentionPolicy.RUNTIME)
public @interface NonCompetitive {
    Locality[] value();
//    src.Locality locality();
}
