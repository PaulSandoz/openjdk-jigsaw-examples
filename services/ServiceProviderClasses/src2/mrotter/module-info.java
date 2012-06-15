module mrotter@1.0 {
  requires mstringer;
        
  provides service stringer.StringTransformer with impl.StringTransformerImpl;
}
