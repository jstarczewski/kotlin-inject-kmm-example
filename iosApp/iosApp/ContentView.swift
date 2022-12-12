import SwiftUI
import shared

struct ContentView: View {
    
    let viewModel : ExampleViewModel = ExampleComponentKt.provideViewModel()
    
	var body: some View {
        Text(viewModel.dummyStringsForUi.joined())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
