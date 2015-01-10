package org.svenehrke.checkout.java8.benjiweber.ternarytrycatch;

import java.lang.reflect.ParameterizedType;

abstract class TryCatch<T, U extends Exception>
{
	public T value()
	{
		try
		{
			return Try();
		} catch (Exception e)
		{
			if (getTypeOfU().isAssignableFrom(e.getClass()))
			{
				return Catch();
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

	public abstract T Try() throws U;

	public abstract T Catch();
}

