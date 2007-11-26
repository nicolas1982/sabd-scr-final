/*
 * JPanelAltaCondicionNumerica.java
 *
 * Created on 22 de noviembre de 2007, 20:59
 */

package layout.panels;

import java.math.BigDecimal;
import java.util.Vector;

import scr.dao.CondicionNumericaDao;
import scr.dao.SectoresDao;
import scr.dao.TipoCondicionNumericaDao;
import scr.entidades.CondicionNumerica;
import scr.entidades.Sector;
import scr.entidades.TipoCondicionNumerica;

/**
 *
 * @author  MARZONGA
 */
public class JPanelAltaCondicionNumerica extends javax.swing.JPanel {
    
	private static final long serialVersionUID = 7144966621497436119L;
	
	SectoresDao sectorDao = new SectoresDao();
	CondicionNumericaDao condicionNumericaDao = new CondicionNumericaDao();
	private TipoCondicionNumericaDao tipoCondNumDao = new TipoCondicionNumericaDao(); 
	
    /** Creates new form JPanelAltaCondicionNumerica */
    public JPanelAltaCondicionNumerica() {
        initComponents();
        extraInitComponents();
    }
    
    private void extraInitComponents() {
    	for(TipoCondicionNumerica t: tipoCondNumDao.getTiposCondicionNumerica()) {
    		jCBTipoCondicion.addItem(t);
    	}
	}

	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLTitulo = new javax.swing.JLabel();
        jBAceptar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLSector = new javax.swing.JLabel();
        jLValor = new javax.swing.JLabel();
        jLInicio = new javax.swing.JLabel();
        jLComparador = new javax.swing.JLabel();
        jLDescripcion = new javax.swing.JLabel();
        jLTipoCondicion = new javax.swing.JLabel();
        jCBSector = new javax.swing.JComboBox();
        jTFDescripcion = new javax.swing.JTextField();
        jCBComparador = new javax.swing.JComboBox();
        jCBInicio = new javax.swing.JComboBox();
        jTFValor = new javax.swing.JTextField();
        jCBTipoCondicion = new javax.swing.JComboBox();

        jLTitulo.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLTitulo.setText("ALTA CONDICI\u00d3N NUM\u00c9RICA");

        jBAceptar.setText("Aceptar");
        jBAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBAceptarKeyPressed(evt);
            }
        });
        jBAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBAceptarMouseClicked(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBCancelarKeyPressed(evt);
            }
        });
        jBCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBCancelarMouseClicked(evt);
            }
        });

        jLSector.setText("Sector");

        jLValor.setText("Valor");

        jLInicio.setText("Inicio");

        jLComparador.setText("Comparador");

        jLDescripcion.setText("Descripci\u00f3n");

        jLTipoCondicion.setText("Tipo Condici\u00f3n");

        jCBSector.setModel(new javax.swing.DefaultComboBoxModel(sectorDao.getSectores().toArray()));

        jCBComparador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ">", "=", "<", "<=", ">="}));

        jCBInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Si", "No"}));

        //jCBTipoCondicion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Temperatura", "Humedad"}));
        
        jCBInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBInicioActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(112, 112, 112)
                        .add(jLTitulo))
                    .add(layout.createSequentialGroup()
                        .add(93, 93, 93)
                        .add(jBAceptar)
                        .add(43, 43, 43)
                        .add(jBCancelar))
                    .add(layout.createSequentialGroup()
                        .add(76, 76, 76)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLSector)
                            .add(jLDescripcion)
                            .add(jLComparador)
                            .add(jLInicio)
                            .add(jLValor)
                            .add(jLTipoCondicion))
                        .add(35, 35, 35)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jCBTipoCondicion, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jCBInicio, 0, 129, Short.MAX_VALUE)
                            .add(jCBComparador, 0, 129, Short.MAX_VALUE)
                            .add(jTFDescripcion)
                            .add(jCBSector, 0, 129, Short.MAX_VALUE)
                            .add(jTFValor))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLTitulo)
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLSector)
                    .add(jCBSector, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLDescripcion)
                    .add(jTFDescripcion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLComparador)
                    .add(jCBComparador, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(11, 11, 11)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLInicio)
                    .add(jCBInicio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLValor)
                    .add(jTFValor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLTipoCondicion)
                    .add(jCBTipoCondicion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 25, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBAceptar)
                    .add(jBCancelar))
                .add(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCBInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBInicioActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jCBInicioActionPerformed

    private void jBCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCancelarMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jBCancelarMouseClicked

    private void jBCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBCancelarKeyPressed
        this.setVisible(false);
    }//GEN-LAST:event_jBCancelarKeyPressed

    private void jBAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAceptarMouseClicked
    	CondicionNumerica condicionNumerica = new CondicionNumerica();
    	condicionNumerica.setComparador(this.jCBComparador.getSelectedIndex());
    	condicionNumerica.setDescripcion(this.jTFDescripcion.toString());
    	condicionNumerica.setDiscriminador(1);
    	Sector sector = (Sector)this.jCBSector.getSelectedItem();
    	condicionNumerica.setIdSector(sector.getIdsector());
    	condicionNumerica.setInicio(this.jCBInicio.getSelectedIndex());
    	condicionNumerica.setTipoCondicionNum(this.jCBTipoCondicion.getSelectedIndex());
    	condicionNumerica.setValorCondicion(new BigDecimal(this.jTFValor.getText()));
    	condicionNumericaDao.insertCondicionNumerica(condicionNumerica);
    	this.setVisible(false);
    }//GEN-LAST:event_jBAceptarMouseClicked

    private void jBAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBAceptarKeyPressed
        this.jBAceptarMouseClicked(null);
    }//GEN-LAST:event_jBAceptarKeyPressed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JComboBox jCBComparador;
    private javax.swing.JComboBox jCBInicio;
    private javax.swing.JComboBox jCBSector;
    private javax.swing.JComboBox jCBTipoCondicion;
    private javax.swing.JLabel jLComparador;
    private javax.swing.JLabel jLDescripcion;
    private javax.swing.JLabel jLInicio;
    private javax.swing.JLabel jLSector;
    private javax.swing.JLabel jLTipoCondicion;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLValor;
    private javax.swing.JTextField jTFDescripcion;
    private javax.swing.JTextField jTFValor;
    // End of variables declaration//GEN-END:variables
    
}
