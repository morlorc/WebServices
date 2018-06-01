package util;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class JaxParser {
	
	/**
	 * Unmarshall un fichier au format File.
	 * @param cl
	 * @param f
	 * @return Une classe provenant d'un fichier .xml.
	 * @throws JAXBException
	 */
	public static <T> T unmarshal(Class<T> cl, File f) throws JAXBException
    {
        return unmarshal(cl, new StreamSource(f));
    }
    
	/**
	 * Unmarshall un fichier au format Source.
	 * @param cl
	 * @param s
	 * @return Une classe provenant d'un fichier .xml.
	 * @throws JAXBException
	 */
	public static <T> T unmarshal(Class<T> cl, Source s) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(cl);
        Unmarshaller u = ctx.createUnmarshaller();
        return u.unmarshal(s, cl).getValue();
    }
	
	/**
	 * Marshall un fichier .xml.
	 * @param obj
	 * @param f
	 * @param path
	 * @throws JAXBException
	 */
    public static <T> void marshal(T obj, File f, String path) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(obj.getClass());
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, path+".xsd");
        m.marshal(obj, f);
    }

}