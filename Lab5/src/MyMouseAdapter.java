import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	private Random generator = new Random();
	 Color oldColor = Color.RED;
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			//Do nothing
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((gridX == 0) && (gridY == 10)) {
				for( int Row = 4;Row <= 6;Row++){
					int Col = 4;
					for (int X = Col; X <=6;X++){
						Color newColor = null;
						switch (generator.nextInt(5)) {
						case 0:
						    newColor = Color.YELLOW;
							break;
								
						case 1:
							newColor = Color.MAGENTA;
							break;
							
						case 2:
							newColor = Color.BLACK;
							break;
							
						case 3:
							newColor = new Color(0x964B00); 
							break;
							//Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
							
						case 4:
								newColor = new Color(0xB57EDC); 
							 //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
							break;
						}
						myPanel.colorArray[Row][X] = newColor;
					    myPanel.repaint();
					    
					}
				}
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX != 0) && (gridY == 0)) {
					for(int i = 1; i < myPanel.TOTAL_ROWS - 1;i++){
						Color newColor = null;
						switch (generator.nextInt(5)) {
						case 0:
						    newColor = Color.YELLOW;
							break;
								
						case 1:
							newColor = Color.MAGENTA;
							break;
							
						case 2:
							newColor = Color.BLACK;
							break;
							
						case 3:
							newColor = new Color(0x964B00); 
							break;
							//Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
							
						case 4:
								newColor = new Color(0xB57EDC); 
							 //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
							break;
						}
						myPanel.colorArray[myPanel.mouseDownGridX ][myPanel.mouseDownGridY + i] = newColor;
					    myPanel.repaint();
					//On the left column and on the top row... do nothing
				}
					
				} else {
					if ((gridX == 0) && ( gridY == 0)) {
						for(int i = 1; i < myPanel.TOTAL_ROWS - 1;i++){
							Color newColor = null;
							switch (generator.nextInt(5)) {
							case 0:
							    newColor = Color.YELLOW;
								break;
									
							case 1:
								newColor = Color.MAGENTA;
								break;
								
							case 2:
								newColor = Color.BLACK;
								break;
								
							case 3:
								newColor = new Color(0x964B00); 
								break;
								//Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
								
							case 4:
									newColor = new Color(0xB57EDC); 
								 //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
								break;
							}
							myPanel.colorArray[myPanel.mouseDownGridX + i][myPanel.mouseDownGridY + i] = newColor;
						    myPanel.repaint();
						//On the left column and on the top row... do nothing
					}
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) && (gridY != 0)) {
							for(int i = 1; i < myPanel.TOTAL_ROWS - 1;i++){
								Color newColor = null;
								switch (generator.nextInt(5)) {
								case 0:
								    newColor = Color.YELLOW;
									break;
										
								case 1:
									newColor = Color.MAGENTA;
									break;
									
								case 2:
									newColor = Color.BLACK;
									break;
									
								case 3:
									newColor = new Color(0x964B00); 
									break;
									//Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
									
								case 4:
										newColor = new Color(0xB57EDC); 
									 //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
									break;
								}
								myPanel.colorArray[myPanel.mouseDownGridX + i][myPanel.mouseDownGridY] = newColor;
							    myPanel.repaint();
							//On the left column and on the top row... do nothing
						}
						}else {
							//On the grid other than on the left column and on the top row:
							Color newColor = null;
		                   
		                    do{
		                    	
							switch (generator.nextInt(5)) {
							case 0:
							    newColor = Color.YELLOW;
								break;
									
							case 1:
								newColor = Color.MAGENTA;
								break;
								
							case 2:
								newColor = Color.BLACK;
								break;
								
							case 3:
								newColor = new Color(0x964B00); 
								break;
								//Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
								
							case 4:
									newColor = new Color(0xB57EDC); 
								 //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
								break;
							}
		                    }while (isRepeated(oldColor,newColor));
		                    oldColor = newColor;
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
						    myPanel.repaint();
		                    
						}
						
					}
				}
			} 
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			//Do nothing
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public boolean isRepeated(Color c1 ,Color c2 ){
		if( c1.equals(c2)){
			return true;
		}
		else {
		return false;
		}
		
	}

	
}