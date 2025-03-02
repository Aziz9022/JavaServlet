/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;
import javax.ejb.Singleton;
@Singleton
public class CountServletHitsBean {
private int hitCount;
public synchronized int getCount()
{
return hitCount++;
}
}