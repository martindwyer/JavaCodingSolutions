/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Vector;

/**
 *
 * @author marti
 */
public interface DataFacade extends ResponderInformation, AreaInformation {
    Vector<ResponderInformation> startingResponders = new Vector<ResponderInformation>();
    
    
}
