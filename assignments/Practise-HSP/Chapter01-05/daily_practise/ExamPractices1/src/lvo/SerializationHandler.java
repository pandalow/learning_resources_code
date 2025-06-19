package lvo;

import java.util.List;

public interface SerializationHandler<E> {
	void serialise(List<E> list); 
	List<E> deserialization();
}

