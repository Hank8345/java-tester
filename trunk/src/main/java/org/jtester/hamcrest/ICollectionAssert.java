package org.jtester.hamcrest;

import java.util.Collection;

public interface ICollectionAssert<T extends Collection, E extends ICollectionAssert<T, ?>> extends IAssert<T, E> {
	E hasItems(Collection collection);

	E hasItems(Object value, Object... values);

	<F> E hasItems(F values[]);

	// boolean
	E hasItems(boolean values[]);

	// byte
	E hasItems(byte values[]);

	// char
	E hasItems(char values[]);

	// short int long
	E hasItems(short values[]);

	E hasItems(int values[]);

	E hasItems(long values[]);

	// float double
	E hasItems(float values[]);

	E hasItems(double values[]);

	// TODO
}
