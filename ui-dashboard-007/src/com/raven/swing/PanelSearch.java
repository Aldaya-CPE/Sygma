/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import net.miginfocom.swing.MigLayout;
public class PanelSearch extends javax.swing.JPanel {
private EventClick event;
    private int selectedIndex = -1;
     public void addEventClick(EventClick event) {
        this.event = event;
    }

    public PanelSearch() {
        initComponents();
                setLayout(new MigLayout("fillx", "0[]0", "0[]0"));

    }

public void setData(List<DataSearch> data) {
        selectedIndex = -1; //  -1 is not selected
        this.removeAll();
        for (DataSearch d : data) {
            Search_Item item = new Search_Item(d);
            //  add event
            item.addEvent(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //  when click
                    event.itemClick(d);
                }
            }, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //  when remove
                    event.itemRemove(item, d);

                }
            });
            this.add(item, "wrap");
            //  wrap mean add to new row after this add
            //  this for miglayout option
        }
        repaint();
        revalidate();
        //  Refresh Component
    }

    public int getItemSize() {
        return getComponentCount();
    }

    public void keyUp() {
        int size = getComponentCount();
        if (size > 0) {
            if (selectedIndex <= 0) {
                selectedIndex = size - 1;
            } else {
                selectedIndex--;
            }
            showSelected();
        }
    }

    public void keyDown() {
        int size = getComponentCount();
        if (size > 0) {
            if (selectedIndex >= size - 1) {
                selectedIndex = 0;
            } else {
                selectedIndex++;
            }
            showSelected();
        }
    }

    public String getSelectedText() {
        if (selectedIndex != -1 && selectedIndex < getComponentCount()) {
            return ((Search_Item) getComponent(selectedIndex)).getText();
        }
        return "";
    }

    public void clearSelected() {
        selectedIndex = -1;
        showSelected();
    }

    private void showSelected() {
        Component com[] = getComponents();
        for (int i = 0; i < com.length; i++) {
            ((Search_Item) com[i]).setSelected(i == selectedIndex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
