public class Solution {
    public IList<string> RemoveSubfolders(string[] folder) {
     Array.Sort(folder);
        
        List<string> result = new List<string>();
        
        if (folder.Length == 0) {
            return result;
        }
        
        result.Add(folder[0]);
        
        for (int i = 1; i < folder.Length; i++) {
            string currentFolder = folder[i];
            string lastAddedFolder = result[result.Count - 1];
            
            // Check if currentFolder is a sub-folder of the lastAddedFolder
            // A sub-folder must start with the parent folder's path followed by a '/'
            if (!(currentFolder.StartsWith(lastAddedFolder + "/") && currentFolder.Length > lastAddedFolder.Length)) {
                result.Add(currentFolder);
            }
        }
        
        return result;   
    }
}