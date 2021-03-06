package burlap.behavior.singleagent.vfa;

import burlap.oomdp.core.AbstractGroundedAction;
import burlap.oomdp.core.states.State;

/**
 * An interface for defining a parametric function. This interface is often used
 * for value function approximation implementations. This highest-level of the interface does not define the input
 * domain, which is left to subclasses of this interface. For example, the {@link ParametricStateFunction} operates
 * on {@link burlap.oomdp.core.states.State} inputs and the {@link ParametricFunction.ParametricStateActionFunction}
 * operates on {@link burlap.oomdp.core.states.State}-{@link burlap.oomdp.core.AbstractGroundedAction} inputs.
 *
 *
 * @author James MacGlashan.
 */
public interface ParametricFunction {

	/**
	 * Returns the number of parameters defining this function. Note that some
	 * implementations my have a dynamic number of parameters that grows or shrinks
	 * over time. Consult the documentation for the specific implementation
	 * for more information.
	 * @return the number of parameters defining this function.
	 */
	int numParameters();


	/**
	 * Returns the value of the ith parameter value
	 * @param i the parameter index
	 * @return the double value of the ith parameter
	 */
	double getParameter(int i);


	/**
	 * Sets the value of the ith parameter to given value
	 * @param i the index of the parameter to set
	 * @param p the parameter value to which it should be set
	 */
	void setParameter(int i, double p);


	/**
	 * Resets the parameters of this function to default values.
	 */
	void resetParameters();


	/**
	 * Returns a copy of this {@link ParametricFunction}.
	 * @return a copy of this {@link ParametricFunction}.
	 */
	ParametricFunction copy();


	/**
	 * A Parametric function that operates on states.
	 */
	public static interface ParametricStateFunction extends ParametricFunction {


		/**
		 * Sets the input of this function to the given {@link burlap.oomdp.core.states.State} and returns
		 * the value of it.
		 * @param s the {@link burlap.oomdp.core.states.State} to input to the function
		 * @return the value of this function evaluated on the input {@link burlap.oomdp.core.states.State}
		 */
		double evaluate(State s);

	}


	/**
	 * A parametric function that operations on state-actions
	 */
	public static interface ParametricStateActionFunction extends ParametricFunction {


		/**
		 * Sets the input of this function to the given {@link burlap.oomdp.core.states.State} and
		 * {@link burlap.oomdp.core.AbstractGroundedAction} and returns the value of it.
		 * @param s the input {@link burlap.oomdp.core.states.State}
		 * @param a the input action
		 * @return the value of this function evaluated on the {@link burlap.oomdp.core.states.State} and {@link burlap.oomdp.core.AbstractGroundedAction}
		 */
		double evaluate(State s, AbstractGroundedAction a);

	}

}
