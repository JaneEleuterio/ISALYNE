package cosmapek.planner.core.sort;

import cosmapek.interfaces.IElement;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public interface Sort {
    public LinkedList<IElement> sort(LinkedList<IElement> input);
}
