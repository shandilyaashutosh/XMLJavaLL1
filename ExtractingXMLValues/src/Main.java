import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Comment;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import java.util.*;


public class Main 
{
    public static void main(String argv[]) throws ParserConfigurationException, SAXException, IOException
    {
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("shipmentDetails_1.xml"));
    	
		System.out.println("DECLARATION : ");
		System.out.println("XML Encoding : " + document.getXmlEncoding());
			
		System.out.println("XML Version : " + document.getXmlVersion());
		
		NodeList shipmentnodelist = document.getElementsByTagName("shipment");
		NodeList namenodelist = document.getElementsByTagName("name");
		NodeList departmentnodelist = document.getElementsByTagName("department");
		NodeList departurePortIdnodelist = document.getElementsByTagName("departurePortId");
		NodeList arrivalPortIdnodelist = document.getElementsByTagName("arrivalPortId");
		NodeList weightnodelist = document.getElementsByTagName("weight");
		NodeList shipmentDatenodelist = document.getElementsByTagName("shipmentDate");
		NodeList descriptionNodeList = document.getElementsByTagName("description");
	
		System.out.println("");
		
		
		
		for(int i =0 ; i< shipmentnodelist.getLength() ; i++)
		{
			System.out.println("Shipment Details " + (i+1) +" :" );
			
			Node shipmentnode = shipmentnodelist.item(i);
			
			NodeList shipmentchildNodes = shipmentnode.getChildNodes();
			for (int j = 0; j < shipmentchildNodes.getLength(); j++) {
	            Node childNode = shipmentchildNodes.item(j);
	            if (childNode.getNodeType() == Node.COMMENT_NODE) {
	                String comment = childNode.getTextContent();
	                System.out.println("\n"+"COMMENTS : \n" + comment);
	            }
			}
			
			Element shipment = (Element) shipmentnode;
			
			String id = shipment.getAttribute("id");
			System.out.println("\nATTRIBUTES : ");
			System.out.println("id : " + id);
			
			System.out.println("\n"+"ELEMENTS : ");
			Node namenode = namenodelist.item(i);
			System.out.println("name : " + namenode.getTextContent()); 
			
			
			Node departmentnamenode = departmentnodelist.item(i);
			System.out.println("department : " + departmentnamenode.getTextContent()); 
			
			Node departurePortIdnode = departurePortIdnodelist.item(i);
			System.out.println("departurePortId : " + departurePortIdnode.getTextContent()); 
			
			Node arrivalPortIdnode = arrivalPortIdnodelist.item(i);
			System.out.println("arrivalPortId : " + arrivalPortIdnode.getTextContent()); 
			
			Node weightnode = weightnodelist.item(i);
			System.out.println("weight : " + weightnode.getTextContent()); 
			
			Node shipmentDatenode = shipmentDatenodelist.item(i);
			System.out.println("shipmentDate : " + shipmentDatenode.getTextContent()); 
			
			Node descriptionNode = descriptionNodeList.item(i);
			System.out.println("\n" +"CDATA SECTION : "+ "\n" + "Description : " + descriptionNode.getTextContent()+"\n");
			
				
			}
			
		}
		
	}


