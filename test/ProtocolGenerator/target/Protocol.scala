package menta.model.util.serialization.protocols

import menta.model._

import sbinary._
import DefaultProtocol._
import Operations._

trait  Protocol 
{
       /*
        Read properties from steam
        @param in - stream of sbinary
        @param obj - object to Update
     */
      override def readProperties(in:Input, obj:Knowledge)=
      {
          super.readProperties(in,obj);
          //cast to 
          var casted=obj.asInstanceOf[];
          //read name
          casted.name= readString(in)
      }

      /*
        write properties to stream
        @param out - stream of sbinary
        @param obj - object to write
      */
      override def writeProperties(out:Output, obj:Knowledge)=
      {
          super.writeProperties(out,obj);
          //cast to HowTo
          var casted=obj.asInstanceOf[];
          //process name
          writeString(out,casted.name);

      }

}
