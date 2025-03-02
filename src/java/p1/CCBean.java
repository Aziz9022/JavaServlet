/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import javax.ejb.Stateless;

/**
 *
 * @author kanoo
 */
@Stateless
public class CCBean implements CCBeanLocal {
 @Override
public double r2d(double r) 
{  
return r/80;  
} 
@Override
public double d2r(double d) 
{  
return d*80;  
}
}
