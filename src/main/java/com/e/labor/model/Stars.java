/*
 * Stars
 */
package com.e.labor.model;

/**
 *
 * @author jasonpalmer
 */
public enum Stars {
    
    _0_25, _0_5, _0_75, _0_1, 
    _1_25, _1_5, _1_75, _2_0, 
    _2_25, _2_5, _2_75, _3_0,
    _3_25, _3_5, _3_75, _4_0, 
    _4_25, _4_5, _4_75, _5_0, 
    _5_25, _5_5, _5_75, _6_0,
    _6_25, _6_5, _6_75, _7_0,
    _7_25, _7_5, _7_75, _8_0,
    _8_25, _8_5, _8_75, _9_0,
    _9_25, _9_5, _9_75, _10_0;
    
    public double getStarValue(){
        String stripped = this.name().replaceFirst("_", "");
        stripped = stripped.replaceFirst("_", ".");
        if(stripped.startsWith("0.")){
            stripped = stripped.replaceFirst("0", "");
        }
        double val = Double.parseDouble(stripped);
        return Double.parseDouble(stripped);
    }
    
    public static void main(String[] args){
        Stars._0_25.getStarValue();
    }
    
    public Stars getStarForValue(short rating){
        String _rating = String.valueOf(rating);
        
        if(_rating.contains(".00")){
            _rating = _rating.replace(".00", ".0");
        }
        if(!_rating.contains(".")){
            _rating = _rating + ".0";
        }
        return Stars.valueOf(String.format("_%s", _rating.replace(".", "_")));
    }
    
    
    
}
