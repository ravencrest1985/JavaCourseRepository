package testing;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import implementation.TaskRemoteImpl;
import interfaces.TaskRemote;

public class Demo {

	public static void main(String[] args) throws NamingException {
//		Properties contextProperties = new Properties();
//        contextProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
//        contextProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//        contextProperties.put("jboss.naming.client.ejb.context", true);
//        Context context = new InitialContext(contextProperties);
		
		System.out.println("Hello From Java!");
	    Properties props = new Properties();
        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
        props.put("java.naming.factory.initial","org.jboss.naming.remote.client.InitialContextFactory");
        props.put("java.naming.provider.url","http-remoting://localhost:8080");
        props.put("jboss.naming.client.ejb.context","true");
        props.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT","false");
        InitialContext context = new InitialContext(props);
        
        String appName = "";        	 
        String moduleName = "EJB-Statefull-Server";
        String distinctName = "";        	 
        String beanName = TaskRemoteImpl.class.getSimpleName();        	 
        String interfaceName = TaskRemote.class.getName();
        String name = "ejb:" + appName + "/" + moduleName + "/" +  distinctName    + "/" + beanName + "!" + interfaceName+"?stateful";
        
        
        TaskRemote todoBean = (TaskRemote) context
                .lookup(name);
        todoBean.addTask("Pierwsze");
        todoBean.addTask("Drugie");
        todoBean.addTask("Trzecie");

        List<String> taskList = todoBean.getTaskList();
        System.out.println(taskList);
        todoBean.closeConnection();

	}

}
