package org.svenehrke.checkout.java8.benjiweber.ternarytrycatch;

import java.lang.reflect.ParameterizedType;
import java.util.function.Supplier;

class TryCatch2<T, U extends Exception>
{
	private final ExcSupplier<T, U> supplier1;
	private final Supplier<T> supplier2;

	protected TryCatch2(ExcSupplier<T, U> supplier1, Supplier<T> supplier2) {
		this.supplier1 = supplier1;
		this.supplier2 = supplier2;
	}

	public T value()
	{
		try
		{
			return supplier1.get();
		} catch (Exception e)
		{
			if (getTypeOfU().isAssignableFrom(e.getClass()))
			{
				return supplier2.get();
			} else
			{
				throw new RuntimeException(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private Class<U> getTypeOfU()
	{
		return (Class<U>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

}

