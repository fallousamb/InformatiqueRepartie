
package ants;



// Imports
///////////////
import jade.core.AID;
import jade.core.Agent;
import jade.core.ProfileImpl;
import jade.core.Profile;

import jade.wrapper.PlatformController;
import jade.wrapper.AgentController;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.DFService;
import jade.domain.FIPAException;

import javax.swing.*;
import java.util.*;
import java.text.NumberFormat;



public class LaunchUI
extends Agent
{

    public final static String MOVE = "MOVE";


	// Static variables
	//////////////////////////////////


	// Instance variables
	//////////////////////////////////
	protected JFrame m_frame = null;
	protected Vector m_guestList = new Vector();    // invitees
	protected int m_guestCount = 0;                 // arrivals
        
        protected Vector m_hunterList = new Vector();    // invitees
	protected int m_hunterCount = 0;                 // arrivals
        
        protected Vector m_woodCuterList = new Vector();    // invitees
	protected int m_woodCuterCount = 0;                 // arrivals

	protected boolean m_partyOver = false;
	protected NumberFormat m_avgFormat = NumberFormat.getInstance();
	protected long m_startTime = 0L;




	// Constructors
	//////////////////////////////////

	/**
	 * Construct the host agent.  Some tweaking of the UI parameters.
	 */
	public LaunchUI() {
		m_avgFormat.setMaximumFractionDigits( 2 );
		m_avgFormat.setMinimumFractionDigits( 2 );
	}



	// External signature methods
	//////////////////////////////////

	/**
	 * Setup the agent.  Registers with the DF, and adds a behaviour to
	 * process incoming messages.
	 */
	protected void setup() {
		try {
			System.out.println( getLocalName() + " setting up");


			// add the GUI
			setupUI();

			// add a Behaviour to handle messages from guests
			addBehaviour( new CyclicBehaviour( this ) {
				public void action() {

				}
			} );
		}
		catch (Exception e) {
			System.out.println( "Saw exception in HostAgent: " + e );
			e.printStackTrace();
		}

	}




	// Internal implementation methods
	//////////////////////////////////

	/**
	 * Setup the UI, which means creating and showing the main frame.
	 */
	private void setupUI() {
		m_frame = new HostUIFrame( this );

		m_frame.setSize( 400, 200 );
		m_frame.setLocation( 400, 400 );
		m_frame.setVisible( true );
		m_frame.validate();
	}



	protected void createAnts( int nGuests ) {
		// remove any old state
		m_guestList.clear();
		m_guestCount = 0;

		m_partyOver = false;
		((HostUIFrame) m_frame).lbl_numIntroductions.setText( "0" );
		((HostUIFrame) m_frame).prog_rumourCount.setValue( 0 );
		((HostUIFrame) m_frame).lbl_rumourAvg.setText( "0.0" );


		System.out.println("Creating "+nGuests +" ants");

		// notice the start time
		m_startTime = System.currentTimeMillis();


		PlatformController container = getContainerController(); // get a container controller for creating new agents
		// create N guest agents
		try {
			for (int i = 0;  i < nGuests;  i++) {
				// create a new agent
				String localName = "guest_"+i;
				AgentController guest = container.createNewAgent(localName, "ants.Ant", null);
				guest.start();
				//Agent guest = new GuestAgent();
				//guest.doStart( "guest_" + i );

				// keep the guest's ID on a local list
				m_guestList.add( new AID(localName, AID.ISLOCALNAME) );
			}
		}
		catch (Exception e) {
			System.err.println( "Exception while adding guests: " + e );
			e.printStackTrace();
		}
	}

        protected void createHunter( int nGuests ) {
		// remove any old state
		m_hunterList.clear();
		m_hunterCount = 0;

		m_partyOver = false;
		((HostUIFrame) m_frame).lbl_numIntroductions.setText( "0" );
		((HostUIFrame) m_frame).prog_rumourCount.setValue( 0 );
		((HostUIFrame) m_frame).lbl_rumourAvg.setText( "0.0" );


		System.out.println("Creating "+nGuests +" hunters");

		// notice the start time
		m_startTime = System.currentTimeMillis();


		PlatformController container = getContainerController(); // get a container controller for creating new agents
		// create N guest agents
		try {
			for (int i = 0;  i < nGuests;  i++) {
				// create a new agent
				String localName = "hunter_"+i;
				AgentController hunter = container.createNewAgent(localName, "ants.Hunter", null);
				hunter.start();
				//Agent guest = new GuestAgent();
				//guest.doStart( "guest_" + i );

				// keep the guest's ID on a local list
				m_hunterList.add( new AID(localName, AID.ISLOCALNAME) );
			}
		}
		catch (Exception e) {
			System.err.println( "Exception while adding hunters: " + e );
			e.printStackTrace();
		}
	}


        protected void createWoodCuter( int nGuests ) {
		// remove any old state
		m_woodCuterList.clear();
		m_woodCuterCount = 0;

		m_partyOver = false;
		((HostUIFrame) m_frame).lbl_numIntroductions.setText( "0" );
		((HostUIFrame) m_frame).prog_rumourCount.setValue( 0 );
		((HostUIFrame) m_frame).lbl_rumourAvg.setText( "0.0" );


		System.out.println("Creating "+nGuests +" WoodCuter");

		// notice the start time
		m_startTime = System.currentTimeMillis();


		PlatformController container = getContainerController(); // get a container controller for creating new agents
		// create N guest agents
		try {
			for (int i = 0;  i < nGuests;  i++) {
				// create a new agent
				String localName = "woodCuter_"+i;
				AgentController guest = container.createNewAgent(localName, "ants.WoodCuter", null);
				guest.start();
				//Agent guest = new GuestAgent();
				//guest.doStart( "guest_" + i );

				// keep the guest's ID on a local list
				m_woodCuterList.add( new AID(localName, AID.ISLOCALNAME) );
			}
		}
		catch (Exception e) {
			System.err.println( "Exception while adding WoodCuter: " + e );
			e.printStackTrace();
		}
	}















	/**
	 * Pick a guest at random who is not the given guest.
	 *
	 * @param aGuest A guest at the party or null
	 * @return A random guest who is not aGuest.
	 */
	protected AID randomGuest( AID aGuest ) {
		AID g = null;

		do {
			int i = (int) Math.round( Math.random() * (m_guestList.size() - 1) );
			g = (AID) m_guestList.get( i );
		} while ((g!=null) && g.equals(aGuest));

		return g;
	}



	//==============================================================================
	// Inner class definitions
	//==============================================================================

}
