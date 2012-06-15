module mhasher@1.0 {
    requires mstringer;
    
    provides service stringer.StringTransformer with hasher.HasherStringTransformer;
}
