package com.codeprep.predicate;

@FunctionalInterface
public interface Predicate<T> {

	public boolean test(T t);
	
	public default Predicate<T> and(Predicate<T> p){
		return t -> test(t) && p.test(t);
	}

	public default Predicate<T> or(Predicate<T> p){
		return t -> test(t) || p.test(t);
	}

	public static <U> Predicate<U> isEqualTo(U u) {
		return t -> t.equals(u);
	}
}
