package village;


import jade.core.AID;


public class posAgent{
public double x,y;
public AID agentAID;
public boolean heardOf = false;

public posAgent(AID a, double x, double y){
  this.x=x;
  this.y=y;
  this.agentAID = a;
}

public void setPos(double x, double y){
  this.x=x;
  this.y=y;
}




}
