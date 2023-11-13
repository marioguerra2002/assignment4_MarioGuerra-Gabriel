package exercise3;

public class Edge {
  protected int v;
  protected int w;
  protected double weight;

  public Edge (int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }
  int Either() {
    return v;
  }
  int Other(int v) {
    if (this.v == v) {
      return w;
    }
    return v;
  }
  public boolean Lessthan (Edge that) { // less than
    return this.weight < that.weight;
  }
  public String Represent() {
    return v + "-" + w + " " + weight;
  }
  public double getWeight() {
    return weight;
  }
  public boolean Equals(Edge that) {
    return this.Either() == that.Either() && this.Other(this.Either()) == that.Other(that.Either());
  }

}
